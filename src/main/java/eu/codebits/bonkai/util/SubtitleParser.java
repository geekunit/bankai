package eu.codebits.bonkai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bmfurtado
 */
public class SubtitleParser {

    private String encoding;
    private InputStream is;

    public SubtitleParser(File file) throws FileNotFoundException {
        this.is = new FileInputStream(file);
    }

    public SubtitleParser(InputStream is) {
        this.is = is;
    }

    public List<Caption> parse() throws IOException, ParseException {
        List<Caption> captions = new ArrayList<Caption>();
        InputStreamReader isreader = new InputStreamReader(is, "ISO-8859-1");
        BufferedReader reader = new BufferedReader(isreader);
        String line;
        Integer lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            Integer number;
            String timecodes;
            List<String> text = new ArrayList<String>();
            try {
                number = Integer.parseInt(line);
            } catch (NumberFormatException nfe) {
                throw new ParseException("The SubRip file is invalid. Invalid sequence number.", lineNumber);
            }

            if((line = reader.readLine()) != null) {
                lineNumber++;
                timecodes = line;
            } else {
                throw new ParseException("The SubRip file is invalid. File truncated.", lineNumber);
            }

            while((line = reader.readLine()) != null && !line.equals("")) {
                lineNumber++;
                text.add(line);
            }
            if(line == null) {
                break;
            }

            captions.add(new Caption(number, timecodes, text));
        }

        return captions;
    }
}
