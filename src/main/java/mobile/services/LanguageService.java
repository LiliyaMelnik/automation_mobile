package mobile.services;

import mobile.po.LanguagePage;

public class LanguageService {
    private final LanguagePage languagePage = new LanguagePage();

    public void changeLangToSpanish() {
        languagePage.clickOnLangBtn().clickOnSpanish();
    }
}
