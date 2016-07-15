package home.kwyho.langtool;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.Chinese;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

/**
 * Created by hok on 7/15/16.
 */
public class LanguageToolWrapper {
    public enum LANGUAGE {BRITISH_ENGLISH, AMERICAN_ENGLISH, CHINESE};

    private JLanguageTool langTool;

    public LanguageToolWrapper(LANGUAGE languageType) throws Exception {
        Language languageModel;
        switch(languageType) {
            case BRITISH_ENGLISH:
                languageModel = new BritishEnglish();
                break;
            case AMERICAN_ENGLISH:
                languageModel = new AmericanEnglish();
                break;
            case CHINESE:
                languageModel = new Chinese();
                break;
            default:
                throw new Exception("Invalid language");
        }
        langTool = new JLanguageTool(languageModel);
    }

    public List<RuleMatch> check(String text) throws IOException {
        return langTool.check(text);
    }

}
