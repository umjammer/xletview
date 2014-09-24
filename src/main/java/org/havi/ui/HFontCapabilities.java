/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HFontCapabilities{
    
    public static final int BASIC_LATIN                            = 1;
    public static final int LATIN_1_SUPPLEMENT                     = 2;
    public static final int LATIN_EXTENDED_A                       = 3;
    public static final int LATIN_EXTENDED_B                       = 4;
    public static final int IPA_EXTENSIONS                         = 5;
    public static final int SPACING_MODIFIER_LETTERS               = 6;
    public static final int COMBINING_DIACRITICAL_MARKS            = 7;
    public static final int BASIC_GREEK                            = 8;
    public static final int GREEK_SYMBOLS_AND_COPTIC               = 9;
    public static final int CYRILLIC                               = 10;
    public static final int ARMENIAN                               = 11;
    public static final int BASIC_HEBREW                           = 12;
    public static final int HEBREW_EXTENDED                        = 13;
    public static final int BASIC_ARABIC                           = 14;
    public static final int ARABIC_EXTENDED                        = 15;
    public static final int DEVANAGARI                             = 16;
    public static final int BENGALI                                = 17;
    public static final int GURMUKHI                               = 18;
    public static final int GUJARATI                               = 19;
    public static final int ORIYA                                  = 20;
    public static final int TAMIL                                  = 21;
    public static final int TELUGU                                 = 22;
    public static final int KANNADA                                = 23;
    public static final int MALAYALAM                              = 24;
    public static final int THAI                                   = 25;
    public static final int LAO                                    = 26;
    public static final int BASIC_GEORGIAN                         = 27;
    public static final int GEORGIAN_EXTENDED                      = 28;
    public static final int HANGUL_JAMO                            = 29;
    public static final int LATIN_EXTENDED_ADDITIONAL              = 30;
    public static final int GREEK_EXTENDED                         = 31;
    public static final int GENERAL_PUNCTUATION                    = 32;
    public static final int SUPERSCRIPTS_AND_SUBSCRIPTS            = 33;
    public static final int CURRENCY_SYMBOLS                       = 34;
    public static final int COMBINING_DIACTRICAL_MARKS_FOR_SYMBOLS = 35;
    public static final int LETTERLIKE_SYMBOLS                     = 36;
    public static final int NUMBER_FORMS                           = 37;
    public static final int ARROWS                                 = 38;
    public static final int MATHEMATICAL_OPERATORS                 = 39;
    public static final int MISCELLANEOUS_TECHNICAL                = 40;
    public static final int CONTROL_PICTURES                       = 41;
    public static final int OPTICAL_CHARACTER_RECOGNITION          = 42;
    public static final int ENCLOSED_ALPHANUMERICS                 = 43;
    public static final int BOX_DRAWING                            = 44;
    public static final int BLOCK_ELEMENTS                         = 45;
    public static final int GEOMETRICAL_SHAPES                     = 46;
    public static final int MISCELLANEOUS_SYMBOLS                  = 47;
    public static final int DINGBATS                               = 48;
    public static final int CJK_SYMBOLS_AND_PUNCTUATION            = 49;
    public static final int HIRAGANA                               = 50;
    public static final int KATAKANA                               = 51;
    public static final int BOPOMOFO                               = 52;
    public static final int HANGUL_COMPATIBILITY_JAMO              = 53;
    public static final int CJK_MISCELLANEOUS                      = 54;
    public static final int ENCLOSED_CJK_LETTERS_AND_MONTHS        = 55;
    public static final int CJK_COMPATIBILITY                      = 56;
    public static final int HANGUL                                 = 57;
    public static final int HANGUL_SUPPLEMENTARY_A                 = 58;
    public static final int HANGUL_SUPPLEMENTARY_B                 = 59;
    public static final int CJK_UNIFIED_IDEOGRAPHS                 = 60;
    public static final int PRIVATE_USE_AREA                       = 61;
    public static final int CJK_COMPATIBILITY_IDEOGRAPHS           = 62;
    public static final int ALPHABETIC_PRESENTATION_FORMS_A        = 63;
    public static final int ARABIC_PRESENTATION_FORMS_A            = 64;
    public static final int COMBINING_HALF_MARKS                   = 65;
    public static final int CJK_COMPATIBILITY_FORMS                = 66;
    public static final int SMALL_FORM_VARIANTS                    = 67;
    public static final int ARABIC_PRESENTATION_FORMS_B            = 68;
    public static final int HALFWIDTH_AND_FULLWIDTH_FORMS          = 69;
    public static final int SPECIALS                               = 70;

    protected HFontCapabilities(){
    }

    public static int[] getSupportedCharacterRanges(java.awt.Font font){
        return (null);
    }

    public static boolean isCharAvailable(java.awt.Font font, char c){
        return (false);
    }
}

