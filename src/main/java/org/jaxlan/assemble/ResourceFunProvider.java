package org.jaxlan.assemble;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResourceFunProvider implements FunProvider {
    private final List<String> quotes;
    private final Random random = new Random();

    public ResourceFunProvider(String resourceUrl) {
        quotes = new ArrayList<>();
        try {
            quotes.addAll(readClasspathResourceToLines(resourceUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will read a resource file (like your list of quotes) into a list of strings.
     *
     * @param path the path to the resource
     * @return the list of quotes
     * @throws IOException if something goes wrong
     */
    private List<String> readClasspathResourceToLines(String path) throws IOException {
        try (InputStream stream = FunProvider.class.getResourceAsStream(path); BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            List<String> lines = new ArrayList<>();

            String line = null;
            while ((line = br.readLine()) != null) {
                String cleanLine = line.trim();

                if (cleanLine.startsWith("#")) {
                    // This is a comment
                    continue;
                }

                lines.add(line);
            }
            return lines;
        }
    }

    @Override
    public String getFun() {
        if (quotes.isEmpty()) {
            return "";
        }
        return quotes.get(random.nextInt(quotes.size()));
    }
}
