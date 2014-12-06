cd project1/
mvn clean
mvn
cd ..
#rm -f output.txt
java -jar project1/target/TIGGER.jar -v small_sample.tig > terminal_result.txt
javac IRGenerator.java
java IRGenerator > ExtractedIR.txt
javac SymbolTableGenerator.java
java SymbolTableGenerator > ExtractedST.txt
