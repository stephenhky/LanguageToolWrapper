package home.kwyho.langtool;

import org.languagetool.rules.RuleMatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	    LanguageToolWrapper tool = new LanguageToolWrapper(LanguageToolWrapper.LANGUAGE.AMERICAN_ENGLISH);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().trim();
        while (text.length()>0) {
            List<RuleMatch> ruleMatches = tool.check(text);
            for (RuleMatch match: ruleMatches) {
                System.out.println("Potential error from " +
                        match.getFromPos() + " to " +
                        match.getToPos() + ": " + match.getMessage());
                System.out.println("Suggested correction: " +
                        match.getSuggestedReplacements());
            }
            text = br.readLine().trim();
        }
        System.out.println("end.");
    }
}
