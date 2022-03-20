/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * The <code>RatingDimension</code> interface represents an
 * individual content rating scheme against which program events are
 * rated.  Each rating region may support multiple rating
 * dimensions. One dimension in the U.S. rating region, for example,
 * is used to describe the MPAA list. The dimension name for such a
 * case may be defined as "MPAA".  Another example of a rating
 * dimension may be an age-based DVB rating.
 * <A HREF="../../../javax/tv/service/guide/ContentRatingAdvisory.html"><CODE>ContentRatingAdvisory</CODE></A></DL>
 * <HR>
 *
 *
 */
public interface RatingDimension
{
    /**
     * Returns a string which represents the dimension name being described by
     * this object. One dimension in the U.S. rating region, for example, is
     * used to describe the MPAA list. The dimension name for such a case may
     * be defined as "MPAA".
     *
     * @return A string representing the name of this rating dimension.
     */
    public java.lang.String getDimensionName();

    /**
     * Returns the number of levels defined for this dimension.
     *
     * @return The number of levels in this dimension.
     */
    public short getNumberOfLevels();

    /**
     * Returns a pair of strings describing the specified rating level for
     * this dimension.
     *
     * @param ratingLevel - The rating level for which to retrieve the textual description.
     * @return A pair of strings representing the names for the specified rating level. The first string represents the abbreviated name for the rating level. The second string represents the full name for the rating level.
     * @throws SIException - If ratingLevel is not valid for this RatingDimension.
     * @see ContentRatingAdvisory.getRatingLevel(java.lang.String)
     */
    public java.lang.String[] getRatingLevelDescription(short ratingLevel) throws SIException;

}
