cd project1/
mvn clean
mvn
cd ..
rm -f output.txt
java -jar project1/target/TIGGER.jar -v small_sample.tig > output.txt
