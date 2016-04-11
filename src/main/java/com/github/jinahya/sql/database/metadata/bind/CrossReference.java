/*
 * Copyright 2013 Jin Kwon <onacit at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.sql.database.metadata.bind;

import java.util.Comparator;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * An entity class for binding the result of
 * {@link java.sql.DatabaseMetaData#getCrossReference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
@XmlRootElement
@XmlType(propOrder = {
    "pkcolumnName", "fkcolumnName", "keySeq", "updateRule", "deleteRule",
    "fkName", "pkName", "deferrability"
})
public class CrossReference extends AbstractChild<Metadata> {

    public static Comparator<CrossReference> natural() {
        return new Comparator<CrossReference>() {
            @Override
            public int compare(final CrossReference o1,
                               final CrossReference o2) {
                // by FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, and KEY_SEQ.
                return new CompareToBuilder()
                        .append(o1.getFktableCat(), o2.getFktableCat())
                        .append(o1.getFktableSchem(), o2.getFktableSchem())
                        .append(o1.getFktableName(), o2.getFktableName())
                        .append(o1.getKeySeq(), o2.getKeySeq())
                        .build();
            }
        };
    }

    @Override
    public String toString() {
        return super.toString() + "{"
               + "pktableCat=" + pktableCat
               + ", pktableSchem=" + pktableSchem
               + ", pktableName=" + pktableName
               + ", pkcolumnName=" + pkcolumnName
               + ", fktableCat=" + fktableCat
               + ", fktableSchem=" + fktableSchem
               + ", fktableName=" + fktableName
               + ", fkcolumnName=" + fkcolumnName
               + ", keySeq=" + keySeq
               + ", updateRule=" + updateRule
               + ", deleteRule=" + deleteRule
               + ", fkName=" + fkName
               + ", pkName=" + pkName
               + ", deferrability=" + deferrability
               + "}";
    }

    // -------------------------------------------------------------- pktableCat
    public String getPktableCat() {
        return pktableCat;
    }

    public void setPktableCat(final String pktableCat) {
        this.pktableCat = pktableCat;
    }

    // ------------------------------------------------------------ pktableSchem
    public String getPktableSchem() {
        return pktableSchem;
    }

    public void setPktableSchem(final String pktableSchem) {
        this.pktableSchem = pktableSchem;
    }

    // ------------------------------------------------------------- pktableName
    public String getPktableName() {
        return pktableName;
    }

    public void setPktableName(final String pktableName) {
        this.pktableName = pktableName;
    }

    // ------------------------------------------------------------ pkColumnName
    public String getPkcolumnName() {
        return pkcolumnName;
    }

    public void setPkcolumnName(final String pkcolumnName) {
        this.pkcolumnName = pkcolumnName;
    }

    // -------------------------------------------------------------- fktableCat
    public String getFktableCat() {
        return fktableCat;
    }

    public void setFktableCat(final String fktableCat) {
        this.fktableCat = fktableCat;
    }

    // ------------------------------------------------------------ fktableSchem
    public String getFktableSchem() {
        return fktableSchem;
    }

    public void setFktableSchem(final String fktableSchem) {
        this.fktableSchem = fktableSchem;
    }

    // ------------------------------------------------------------- fktableName
    public String getFktableName() {
        return fktableName;
    }

    public void setFktableName(final String fktableName) {
        this.fktableName = fktableName;
    }

    // ------------------------------------------------------------ fkcolumnName
    public String getFkcolumnName() {
        return fkcolumnName;
    }

    public void setFkcolumnName(final String fkcolumnName) {
        this.fkcolumnName = fkcolumnName;
    }

    // ------------------------------------------------------------------ keySeq
    public short getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(final short keySeq) {
        this.keySeq = keySeq;
    }

    // -------------------------------------------------------------- updateRule
    public short getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(final short updateRule) {
        this.updateRule = updateRule;
    }

    // -------------------------------------------------------------- deleteRule
    public short getDeleteRule() {
        return deleteRule;
    }

    public void setDeleteRule(final short deleteRule) {
        this.deleteRule = deleteRule;
    }

    // ------------------------------------------------------------------ fnname
    public String getFkName() {
        return fkName;
    }

    public void setFkName(final String fkName) {
        this.fkName = fkName;
    }

    // ------------------------------------------------------------------ pkName
    public String getPkName() {
        return pkName;
    }

    public void setPkName(final String pkName) {
        this.pkName = pkName;
    }

    // --------------------------------------------------------- deferrerability
    public short getDeferrability() {
        return deferrability;
    }

    public void setDeferrability(final short deferrability) {
        this.deferrability = deferrability;
    }

    // ---------------------------------------------------------------- metadata
    // just for class diagram
    private Metadata getMetadata() {
        return getParent();
    }

//    public void setMetadata(final Metadata metadata) {
//
//        setParent(metadata);
//    }
//
//
//    CrossReference metadata(final Metadata metadata) {
//
//        setMetadata(metadata);
//
//        return this;
//    }
    // -------------------------------------------------------------------------
    @_Label("PKTABLE_CAT")
    @_NillableBySpecification
    @XmlAttribute
    private String pktableCat;

    @_Label("PKTABLE_SCHEM")
    @_NillableBySpecification
    @XmlAttribute
    private String pktableSchem;

    @_Label("PKTABLE_NAME")
    @XmlAttribute
    private String pktableName;

    @_Label("PKCOLUMN_NAME")
    @XmlElement(required = true)
    private String pkcolumnName;

    @_Label("FKTABLE_CAT")
    @_NillableBySpecification
    @XmlAttribute
    private String fktableCat;

    @_Label("FKTABLE_NAME")
    @_NillableBySpecification
    @XmlAttribute
    private String fktableSchem;

    @_Label("FKTABLE_NAME")
    @XmlAttribute
    private String fktableName;

    @_Label("FKCOLUMN_NAME")
    @XmlElement(required = true)
    private String fkcolumnName;

    @_Label("FKCOLUMN_NAME")
    @XmlElement(required = true)
    private short keySeq;

    @_Label("UPDATE_RULE")
    @XmlElement(required = true)
    private short updateRule;

    @_Label("DELETE_RULE")
    @XmlElement(required = true)
    private short deleteRule;

    @_Label("FK_NAME")
    @_NillableBySpecification
    @XmlElement(nillable = true, required = true)
    private String fkName;

    @_Label("PK_NAME")
    @_NillableBySpecification
    @XmlElement(nillable = true, required = true)
    private String pkName;

    @_Label("DEFERRABILITY")
    @XmlElement(required = true)
    private short deferrability;
}
