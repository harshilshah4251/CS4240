package cs4240_team1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import utility.Utility;

/**
 * Driver class for our Tiger Lexer/Parser
 */
public class TigerMain {
	
	/* OR these ints together to toggle various debug/printing functionality */
	static final int DEBUG_LEXERPARSER     = 0x0000001;
	static final int DEBUG_SYMBOLTABLES    = 0x0000002;
	static final int DEBUG_IR_GENERATION   = 0x0000004;
	static final int DEBUG_CODE_GENERATION = 0x0000008;

	/**
	 * by default, don't print anything extra.
	 */
	static int DEBUG_MODE = 0;
	
	/** pass in one of the flags, this returns true if the functionality it 
	 * represents is turned on in DEBUG_MODE, otherwise false.
	 */
	public static boolean testFlag(int flag) {
		return (flag == (flag & DEBUG_MODE));
	}

	public static void main(String[] args) throws IOException {

		/*
		 * currently, this is the main variable that controls the amount of
		 * output to show.
		 */

		OptionParser oparser = new OptionParser() {
			{
				acceptsAll(Arrays.asList("h", "?"), "print help");
				accepts("v",
						"verbose (complete) output. "
								+ "If this is on, lexer output, parser output, symbol table output,"
								+ " and any additional debugging info will be printed.  Defaults to"
								+ " off.");
				accepts("s",
						"print symbol tables.  Included within -v.");
				accepts("p",
						"print parser/lexer tokens. Included within -v.");
			}
		};

		OptionSet options = oparser.parse(args);

		if (args.length == 0) {
			System.out.println("input file required!");
			System.out.println();
		}
		if (args.length == 0 || options.has("h")) {
			System.out
					.println("TIGGER - CS4400 Fall 2014 Team 1 Tiger Compiler");
			System.out
					.println("===============================================");
			System.out
					.println("Usage: java -jar TIGGER.jar [-v] [-p] [-s] [-h] {inputfile.tig}");
			System.out
					.println("Description: By default, currently prints the IR \n"
							+ "code representation of the input file to standard out.\n"
							+ "By enabling the -v flag, you can obtain more output.\n"
							+ "\nnote: all options will include IR code");
			System.out.println();
			oparser.printHelpOn(System.out);
			System.out.println();
			System.out.println("Authors:");
			System.out.println("Max Virgil, Scott Vermeyen, Currell Berry");
			return;
		}

		if (options.has("v")) {
			/* then print everything out */
			DEBUG_MODE = DEBUG_MODE | DEBUG_LEXERPARSER | DEBUG_SYMBOLTABLES
					| DEBUG_IR_GENERATION | DEBUG_CODE_GENERATION;
		}

		if (options.has("s")) {
			DEBUG_MODE = DEBUG_MODE | DEBUG_SYMBOLTABLES;
		}

		if (options.has("p")) {
			DEBUG_MODE = DEBUG_MODE | DEBUG_LEXERPARSER;
		}

		Object o = options.nonOptionArguments().get(0);
		String inputFileName = o.toString();

		InputStream nis;
		try {
			nis = new FileInputStream(inputFileName);
		} catch (FileNotFoundException e) {
			System.out.println("could not find input file specified!");
			return;
		}

		ANTLRInputStream input = null;
		TigerLexer lexer = null;
		TigerTokenStream tokens = null;
		TigerParser parser = null;
		Object ast = null;

		Utility.formatHeaderForOutput("");

		System.out.println("Reading input from file or stdin");
		try {
			input = new ANTLRInputStream(nis);
		} catch (Exception e) {
			System.err
					.println("error: unable to use input stream specified as ANTLRInputStream\nterminating...");
			System.exit(0);
		}

		lexer = new TigerLexer(input);
		tokens = testFlag(DEBUG_LEXERPARSER)? new TigerDebugTokenStream(lexer)
				: new TigerTokenStream(lexer);
		parser = new TigerParser(tokens);

		/*
		 * for formatting purposes, add a line break between token names and
		 * error message in debug mode
		 */
		if (testFlag(DEBUG_LEXERPARSER)) {
			parser.errorPrefix = "\n\n";
		}

		System.out
				.printf("%sParsing input...%s\n",
						testFlag(DEBUG_LEXERPARSER)? "Running in debug mode (tokens will be printed as parser consumes them)...\n"
								: "",
						testFlag(DEBUG_LEXERPARSER)? "\n\nTokens consumed by parser:" : "");

		try {
			ast = parser.tiger_program().getTree();
		} catch (RecognitionException e) {
			System.err
					.println("error: parser threw RecognitionException while parsing input");
			e.printStackTrace();
			System.err.println("\nterminating...");
			System.exit(0);
		}

		if (parser.getNumberOfSyntaxErrors() == 0
				&& lexer.getNumberOfSyntaxErrors() == 0) {
			System.out.println("\n\nSuccessful parse!");
			walkAST(ast);
		} else {
			System.out.println("\n\nUnsuccessful parse");
		}
		System.out.println(Utility.formatHeaderForOutput(""));

	}

	private static void walkAST(Object ast) {
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(ast);
		SymTableWalker walker = new SymTableWalker(nodeStream);

		CommonTreeNodeStream nodeStream2 = new CommonTreeNodeStream(ast);
		IRCodeWalker irCodeGenerator = new IRCodeWalker(nodeStream2);

		System.out
				.println("Building symbol table and performing semantic checks...");

		try {
			walker.walk();
			if (testFlag(DEBUG_SYMBOLTABLES)) {
				System.out.println(walker.globalSymbolTable
						.recursivePrettyPrintString());
			}

			/* do not generate IR code if semantically invalid */
			System.out.println("Successfully finished semantic checks");
			if (!walker.errors.isEmpty()) {
				System.out.println("ERRORS.");
				for (SemanticError e : walker.errors) {
					System.out.println(e.toString());
				}

				System.out.println("There were semantic errors!  Exiting.");
				return;
			} else {
				irCodeGenerator.globalSymbolTable = walker.globalSymbolTable;
				irCodeGenerator.walk();
				

				if (testFlag(DEBUG_SYMBOLTABLES)) {
					System.out.println(Utility.formatHeaderForOutput("TEMP SYMBOL TABLE"));
					System.out.println(irCodeGenerator.g.getTempSymbolTable()
							.recursivePrettyPrintString());
				}
                
                System.out.println(Utility.formatHeaderForOutput("Ended symbol table and giving you IR Code..."));
				System.out.println(Utility.formatHeaderForOutput("IR CODE"));
				irCodeGenerator.g.printString();
                

				System.out.println(Utility.formatHeaderForOutput("END IR CODE"));

				/**
				 * TODO Implement the Naitve allocation scheme here.
				 * Should add if statements to decide whether using naive or other allocation analyses
				 */
				System.out.println(Utility.formatHeaderForOutput("ASSEMBLY CODE WITH NAIVE REG ALLOC"));

				//System.out.println("[DEBUG] root symbolTable is: " + walker.globalSymbolTable);
				//System.out.print("[DEBUG] children are: ");
				//List<SymbolTable> children = walker.globalSymbolTable.getChildren();
				    //for (SymbolTable child : children) {
					//System.out.print(child + "\n[DEBUG] ");
				    //}
				//System.out.print("\n");
				Naive naiveAllocation = new Naive(irCodeGenerator.g.getCodeList());
				naiveAllocation.generateAssembly();
				System.out.println(Utility.formatHeaderForOutput("END ASSEMBLY CODE WITH NAIVE REG ALLOC"));
				
			}

		} catch (RecognitionException e) {
			System.err
					.println("error: tree walker threw RecognitionException while walking tree");
			e.printStackTrace();
			System.err.println("\nterminating...");
			System.exit(0);
		}
    }
}
