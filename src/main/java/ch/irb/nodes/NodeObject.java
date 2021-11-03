/*
 * Copyright 2020 - Mathilde Foglierini Perez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package ch.irb.nodes;


import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;

import ch.irb.translation.Translator;

/**
 * @author Mathilde This class will contains the main characteristics of a node used in the algo to create the tree AND
 *         used in the GUI
 */
public class NodeObject {
    static Logger logger = LogManager.getLogger(NodeObject.class);

    protected boolean isRoot = false;
    protected boolean isDNA = true;
    protected String nodeId = "";
    protected String sequence;
    protected String proteinSequence;
    protected String cdr_fr_regions;
    protected String imgtFormatSequence;

    protected String cellInfo = null;
    protected String immunizationInfo = null;
    protected String EC50 = null;
    protected String comment1 = null;
    protected boolean showComment1 = true;
    protected String comment2 = null;


    protected String reverseInformation = null;
    protected String doubleMutationInformation = null;
    protected String mutationsWithParent = null;
    protected int numberOfNucMutationsWithParent = 0;
    protected int numberOfAAMutationsWithParent = 0;

    // for graphic purpose
    protected int level = 0;

    protected int deletionNumber;

    protected int insertionNumber;

    protected boolean hasReversion = false;
    protected boolean hasDeletion = false;
    protected boolean hasInsertion = false;

    protected boolean isBP = false;

    public NodeObject() {

    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the isBP
     */
    public boolean isBP() {
        return isBP;
    }

    /**
     * @param isBP the isBP to set
     */
    public void setBP(boolean isBP) {
        this.isBP = isBP;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
        setProteinSequence();
    }

    public void setProteinSequence() {
        //System.out.println("Protein sequence for " + nodeId + " is: " + proteinSequence);
        Translator translator = new Translator(sequence, isDNA);
        proteinSequence = translator.getProteinSequence();
        // logger.debug("Protein sequence for " + nodeId + " is: " + proteinSequence);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProteinSequence() {
        return proteinSequence;
    }

    /**
     * @return the isDNA
     */
    public boolean isDNA() {
        return isDNA;
    }

    /**
     * @param isDNA the isDNA to set
     */
    public void setDNA(boolean isDNA) {
        this.isDNA = isDNA;
    }

    // Here we store the mutations with the parent like: 81:A->C, 98:A->T, ...)
    public void setMutationsWithParent(String mutationsWithParent) {
        this.mutationsWithParent = mutationsWithParent;
    }

    public String getMutationsWithParent() {
        return mutationsWithParent;
    }

    /**
     * @param numberOfNucMutationsWithParent the numberOfNucMutationsWithParent to set
     */
    public void setNumberOfNucMutationsWithParent(int numberOfNucMutationsWithParent) {
        this.numberOfNucMutationsWithParent = numberOfNucMutationsWithParent;
    }

    /**
     * @param numberOfAAMutationsWithParent the numberOfAAMutationsWithParent to set
     */
    public void setNumberOfAAMutationsWithParent(int numberOfAAMutationsWithParent) {
        this.numberOfAAMutationsWithParent = numberOfAAMutationsWithParent;
    }

    /**
     * @param reverseInformation the reverseInformation to set
     */
    public void setReverseInformation(String reverseInformation) {
        this.reverseInformation = reverseInformation;
    }

    public void setCellInfo(String cellInfo) {
        this.cellInfo = cellInfo;
    }

    public void setImmunizationInfo(String immunizationInfo) {
        this.immunizationInfo = immunizationInfo;
    }

    /**
     * @param doubleMutationInformation the doubleMutationInformation to set
     */
    public void setDoubleMutationInformation(String doubleMutationInformation) {
        this.doubleMutationInformation = doubleMutationInformation;
    }

    /**
     * @return the numberOfNucMutationsWithParent
     */
    public int getNumberOfNucMutationsWithParent() {
        return numberOfNucMutationsWithParent;
    }

    /**
     * @return the numberOfAAMutationsWithParent
     */
    public int getNumberOfAAMutationsWithParent() {
        return numberOfAAMutationsWithParent;
    }

    /**
     * @return the reverseInformation
     */
    public String getReverseInformation() {
        return reverseInformation;
    }

    /**
     * @return the doubleMutationInformation
     */
    public String getDoubleMutationInformation() {
        return doubleMutationInformation;
    }

    /**
     * @return the cellInfo
     */
    public String getCellInfo() {
        return cellInfo;
    }

    /**
     * @return the immunizationInfo
     */
    public String getImmunizationInfo() {
        return immunizationInfo;
    }

    /**
     * @return the eC50
     */
    public String getEC50() {
        return EC50;
    }

    /**
     * @param eC50 the eC50 to set
     */
    public void setEC50(String eC50) {
        //logger.warn("!!!!!!!!!!SET EC50 "+eC50+" for node "+nodeId);
        EC50 = eC50;
    }

    /**
     * @return the comment1
     */
    public String getComment1() {
        return comment1;
    }

    /**
     * @param comment1 the comment1 to set
     */
    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    /**
     * @return the showComment1
     */
    public boolean isShowComment1() {
        return showComment1;
    }

    /**
     * @param showComment1 the showComment1 to set
     */
    public void setShowComment1(boolean showComment1) {
        this.showComment1 = showComment1;
    }

    /**
     * @return the comment2
     */
    public String getComment2() {
        return comment2;
    }

    /**
     * @param comment2 the comment2 to set
     */
    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    /**
     * @return the deletionNumber
     */
    public int getDeletionNumber() {
        return deletionNumber;
    }

    /**
     * @param deletionNumber the deletionNumber to set
     */
    public void setDeletionNumber(int deletionNumber) {
        this.deletionNumber = deletionNumber;
    }

    /**
     * @return the insertionNumber
     */
    public int getInsertionNumber() {
        return insertionNumber;
    }

    /**
     * @param insertionNumber the insertionNumber to set
     */
    public void setInsertionNumber(int insertionNumber) {
        this.insertionNumber = insertionNumber;
    }

    /**
     * @return the hasInsertion
     */
    public boolean hasInsertion() {
        return hasInsertion;
    }

    public void setHasInsertion(boolean hasInsertion) {
        this.hasInsertion = hasInsertion;
    }

    /**
     * @return the hasDeletion
     */
    public boolean hasDeletion() {
        return hasDeletion;
    }

    public void setHasDeletion(boolean hasDeletion) {
        this.hasDeletion = hasDeletion;
    }

    /**
     * @param hasDeletion the hasDeletion to set
     */
    public void setDeletion(boolean hasDeletion) {
        this.hasDeletion = hasDeletion;
        char[] seq = getSequence().toCharArray();
        int numberNucleotides = seq.length;
        if (hasDeletion) {
            deletionNumber = 0;
            for (int z = 0; z < numberNucleotides; z++) {
                String nuc2 = Character.toString(seq[z]);
                if (nuc2.equals("-")) {
                    deletionNumber++;
                }
            }
        }
    }

    // This method is used when a BP sequence has the deletion in its shared mutations
    // we want it is displayed in the GUI only in the BP node
    public void removeDeletionIntoTheChild(Integer position) {
        char[] seq = getSequence().toCharArray();
        String nuc = Character.toString(seq[position.intValue()]);
        if (nuc.equals("-")) {
            deletionNumber--;
        }
        // if (deletionNumber == 0)
        // hasDeletion = false;
    }

    /**
     * @param hasInsertion the hasInsertion to set
     */
    public void setInsertion(boolean hasInsertion, char[] glSequence) {
        this.hasInsertion = hasInsertion;
        int numberNucleotides = glSequence.length;
        char[] seq = getSequence().toCharArray();
        if (hasInsertion) {
            insertionNumber = 0;
            for (int z = 0; z < numberNucleotides; z++) {
                String nuc1 = Character.toString(glSequence[z]);
                String nuc2 = Character.toString(seq[z]);
                if (nuc1.equals("-") && !nuc2.equals("-")) {
                    insertionNumber++;
                }
            }
        }
    }

    /**
     * @return the cdr_fr_regions
     */
    public String getCdr_fr_regions() {
        return cdr_fr_regions;
    }

    /**
     * @param cdr_fr_regions the cdr_fr_regions to set
     */
    public void setCdr_fr_regions(String cdr_fr_regions) {
        this.cdr_fr_regions = cdr_fr_regions;
    }

    /**
     * @return the imgtFormatSequence
     */
    public String getImgtFormatSequence() {
        return imgtFormatSequence;
    }


    public String getImgtFormatSequenceWithoutCDR3() {
        if (imgtFormatSequence == null) {
            return null;
        }
        String sequence = imgtFormatSequence;
        String[] regions = getCdr_fr_regions().split("\\s+");
        int startCDR3 = Integer.parseInt(regions[4]);
        int endCDR3 = Integer.parseInt(regions[5]);
        //logger.warn("CDR3 start "+startCDR3+ "and end "+endCDR3);
        String start = sequence.substring(0, startCDR3);
        String end = sequence.substring(endCDR3);
        String middle = "";
        for (int i = startCDR3; i < endCDR3; i++) {
            middle += ".";
        }
        return (start + middle + end);
    }

    /**
     * @param imgtFormatSequence the imgtFormatSequence to set
     */
    public void setImgtFormatSequence(String imgtFormatSequence) {
        this.imgtFormatSequence = imgtFormatSequence;
    }

    // This method is used when a BP sequence has the deletion in its shared mutations
    // we want it is displayed in the GUI only in the BP node
    public void removeInsertionIntoTheChild(Integer position, char[] glSequence) {
        char[] seq = getSequence().toCharArray();
        String nuc = Character.toString(seq[position.intValue()]);
        String rootNuc = Character.toString(glSequence[position.intValue()]);
        if (rootNuc.equals("-") && nuc.matches("\\w")) {
            insertionNumber--;
        }
        if (insertionNumber == 0) {
            hasInsertion = false;
        }
    }

    public int compareTwoProteinSequences(String protSequence1, String protSequence2) {
        int numberOfMutations = 0;
        if (protSequence1.length() != protSequence2.length()) {
            logger.error("!!!!!!!!!!!! BE CAREFUL, these 2 protein sequences dont have the same lengt!!");
            return 0;
        }
        for (int i = 0; i < protSequence1.length(); i++) {
            if (protSequence1.charAt(i) != protSequence2.charAt(i)) {
                numberOfMutations++;
            }
        }
        return numberOfMutations;
    }

}
