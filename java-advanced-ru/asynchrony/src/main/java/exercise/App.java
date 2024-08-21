package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
//import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
//import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String outFile)
            throws ExecutionException, InterruptedException {
        CompletableFuture<String> read1 = CompletableFuture.supplyAsync(() -> {
            var path1 = Paths.get(file1).toAbsolutePath();
            String text1 = "";
            try {
                text1 = Files.readString(path1).trim();
            } catch (Exception e) {
                System.out.println(e);
            }
            return text1;
        });

        CompletableFuture<String> read2 = CompletableFuture.supplyAsync(() -> {
            var path1 = Paths.get(file2).toAbsolutePath();
            String text2 = "";
            try {
                text2 = Files.readString(path1).trim();
            } catch (Exception e) {
                System.out.println(e);
            }
            return text2;
        });

        CompletableFuture<String> phrase = read1.thenCombine(read2, (text1, text2) -> {
            var result = text1 + " " + text2;
            try {
                Files.writeString(Path.of(outFile).toAbsolutePath(), result, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }).exceptionally(ex -> null);
        return phrase;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var phrase = unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt")
                .get();
        System.out.println(phrase);
        // END
    }
}

