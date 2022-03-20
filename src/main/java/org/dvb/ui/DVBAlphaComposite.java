/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.ui;

/**
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public final class DVBAlphaComposite {

    public static final int    CLEAR        = 1;

    public static final int    SRC            = 2;

    public static final int    SRC_OVER    = 3;

    public static final int    DST_OVER    = 4;

    public static final int    SRC_IN        = 5;

    public static final int    DST_IN        = 6;

    public static final int    SRC_OUT        = 7;

    public static final int    DST_OUT        = 8;

    public static final DVBAlphaComposite Clear    = new DVBAlphaComposite(CLEAR);

    public static final DVBAlphaComposite Src    = new DVBAlphaComposite(SRC);

    public static final DVBAlphaComposite SrcOver    = new DVBAlphaComposite(SRC_OVER);

    public static final DVBAlphaComposite DstOver    = new DVBAlphaComposite(DST_OVER);

    public static final DVBAlphaComposite SrcIn    = new DVBAlphaComposite(SRC_IN);

    public static final DVBAlphaComposite DstIn    = new DVBAlphaComposite(DST_IN);

    public static final DVBAlphaComposite SrcOut    = new DVBAlphaComposite(SRC_OUT);

    public static final DVBAlphaComposite DstOut    = new DVBAlphaComposite(DST_OUT);

    private static final int MIN_RULE = CLEAR;
    private static final int MAX_RULE = DST_OUT;

    float extraAlpha;
    int rule;

    private DVBAlphaComposite(int rule) {
        this(rule, 1.0f);
    }

    private DVBAlphaComposite(int rule, float alpha) {
        if (alpha < 0.0f || alpha > 1.0f) {
            throw new IllegalArgumentException("alpha value out of range");
        }
        if (rule < MIN_RULE || rule > MAX_RULE) {
            throw new IllegalArgumentException("unknown composite rule");
        }
        this.rule = rule;
        this.extraAlpha = alpha;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DVBAlphaComposite)) {
            return false;
        }

        DVBAlphaComposite ac = (DVBAlphaComposite) obj;

        if (rule != ac.rule) {
            return false;
        }

        if (extraAlpha != ac.extraAlpha) {
            return false;
        }

        return true;
    }

    public float getAlpha() {
        return extraAlpha;
    }

    public static DVBAlphaComposite getInstance(int rule) {
        switch (rule) {
        case CLEAR:
            return Clear;
        case SRC:
            return Src;
        case SRC_OVER:
            return SrcOver;
        case DST_OVER:
            return DstOver;
        case SRC_IN:
            return SrcIn;
        case DST_IN:
            return DstIn;
        case SRC_OUT:
            return SrcOut;
        case DST_OUT:
            return DstOut;
        default:
            throw new IllegalArgumentException("unknown composite rule");
        }
    }

    public static DVBAlphaComposite getInstance(int rule, float alpha) {
        if (alpha == 1.0f) {
            return getInstance(rule);
        }
        return new DVBAlphaComposite(rule, alpha);
    }

    public int getRule() {
        return rule;
    }
}
