/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.03.25 at 11:44:51 AM CET 
//

package fr.cls.atoll.motu.web.dal.tds.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import fr.cls.atoll.motu.web.dal.tds.model.Aggregation.Scan;
import fr.cls.atoll.motu.web.dal.tds.model.Aggregation.ScanFmrc;
import fr.cls.atoll.motu.web.dal.tds.model.Aggregation.VariableAgg;
import fr.cls.atoll.motu.web.dal.tds.model.Sort.LexigraphicByName;
import fr.cls.atoll.motu.web.dal.tds.model.SourceType.Contact;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated
 * in the fr.cls.atoll.motu.library.misc.tds.server package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML
 * content. The Java representation of XML content can consist of schema derived interfaces and classes
 * representing the binding of schema type definitions, element declarations and model groups. Factory methods
 * for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NamerRegExpOnPath_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "regExpOnPath");
    private final static QName _NamerRegExpOnName_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "regExpOnName");
    private final static QName _Dataset_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "dataset");
    private final static QName _CatalogRef_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "catalogRef");
    private final static QName _DatasetFmrc_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "datasetFmrc");
    private final static QName _DatasetScan_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "datasetScan");
    private final static QName _FilterInclude_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "include");
    private final static QName _FilterExclude_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "exclude");
    private final static QName _DatasetTypeKeyword_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "keyword");
    private final static QName _DatasetTypeDataType_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "dataType");
    private final static QName _DatasetTypeAuthority_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "authority");
    private final static QName _DatasetTypeProject_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "project");
    private final static QName _DatasetTypePublisher_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "publisher");
    private final static QName _DatasetTypeCreator_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "creator");
    private final static QName _DatasetTypeServiceName_QNAME = new QName(
            "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0",
            "serviceName");
    private final static QName _DatasetTypeDate_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "date");
    private final static QName _DatasetTypeTimeCoverage_QNAME = new QName(
            "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0",
            "timeCoverage");
    private final static QName _DatasetTypeDataFormat_QNAME = new QName(
            "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0",
            "dataFormat");
    private final static QName _DatasetTypeDocumentation_QNAME = new QName(
            "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0",
            "documentation");
    private final static QName _TimeCoverageTypeStart_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "start");
    private final static QName _TimeCoverageTypeDuration_QNAME = new QName(
            "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0",
            "duration");
    private final static QName _TimeCoverageTypeEnd_QNAME = new QName("http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", "end");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for
     * package: fr.cls.atoll.motu.library.misc.tds.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatasetRoot }
     * 
     */
    public DatasetRoot createDatasetRoot() {
        return new DatasetRoot();
    }

    /**
     * Create an instance of {@link LexigraphicByName }
     * 
     */
    public LexigraphicByName createSortLexigraphicByName() {
        return new LexigraphicByName();
    }

    /**
     * Create an instance of {@link NamerSelectorType }
     * 
     */
    public NamerSelectorType createNamerSelectorType() {
        return new NamerSelectorType();
    }

    /**
     * Create an instance of {@link Attribute }
     * 
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link Variables }
     * 
     */
    public Variables createVariables() {
        return new Variables();
    }

    /**
     * Create an instance of {@link Scan }
     * 
     */
    public Scan createAggregationScan() {
        return new Scan();
    }

    /**
     * Create an instance of {@link VariableMap }
     * 
     */
    public VariableMap createVariableMap() {
        return new VariableMap();
    }

    /**
     * Create an instance of {@link SourceType }
     * 
     */
    public SourceType createSourceType() {
        return new SourceType();
    }

    /**
     * Create an instance of {@link DatasetScan }
     * 
     */
    public DatasetScan createDatasetScan() {
        return new DatasetScan();
    }

    /**
     * Create an instance of {@link VariableAgg }
     * 
     */
    public VariableAgg createAggregationVariableAgg() {
        return new VariableAgg();
    }

    /**
     * Create an instance of {@link VariableDesc }
     * 
     */
    public VariableDesc createVariableDesc() {
        return new VariableDesc();
    }

    /**
     * Create an instance of {@link AddLatest }
     * 
     */
    public AddLatest createAddLatest() {
        return new AddLatest();
    }

    /**
     * Create an instance of {@link Sort }
     * 
     */
    public Sort createSort() {
        return new Sort();
    }

    /**
     * Create an instance of {@link Variable }
     * 
     */
    public Variable createVariable() {
        return new Variable();
    }

    /**
     * Create an instance of {@link GeospatialCoverage }
     * 
     */
    public GeospatialCoverage createGeospatialCoverage() {
        return new GeospatialCoverage();
    }

    /**
     * Create an instance of {@link CatalogRef }
     * 
     */
    public CatalogRef createCatalogRef() {
        return new CatalogRef();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link ScanFmrc }
     * 
     */
    public ScanFmrc createAggregationScanFmrc() {
        return new ScanFmrc();
    }

    /**
     * Create an instance of {@link DatasetFmrc }
     * 
     */
    public DatasetFmrc createDatasetFmrc() {
        return new DatasetFmrc();
    }

    /**
     * Create an instance of {@link LatestComplete }
     * 
     */
    public LatestComplete createLatestComplete() {
        return new LatestComplete();
    }

    /**
     * Create an instance of {@link Catalog }
     * 
     */
    public Catalog createCatalog() {
        return new Catalog();
    }

    /**
     * Create an instance of {@link FmrcInventory }
     * 
     */
    public FmrcInventory createFmrcInventory() {
        return new FmrcInventory();
    }

    /**
     * Create an instance of {@link LogicalView }
     * 
     */
    public LogicalView createLogicalView() {
        return new LogicalView();
    }

    /**
     * Create an instance of {@link AddProxies }
     * 
     */
    public AddProxies createAddProxies() {
        return new AddProxies();
    }

    /**
     * Create an instance of {@link AddTimeCoverage }
     * 
     */
    public AddTimeCoverage createAddTimeCoverage() {
        return new AddTimeCoverage();
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link SimpleLatest }
     * 
     */
    public SimpleLatest createSimpleLatest() {
        return new SimpleLatest();
    }

    /**
     * Create an instance of {@link DocumentationType }
     * 
     */
    public DocumentationType createDocumentationType() {
        return new DocumentationType();
    }

    /**
     * Create an instance of {@link Netcdf }
     * 
     */
    public Netcdf createNetcdf() {
        return new Netcdf();
    }

    /**
     * Create an instance of {@link Values }
     * 
     */
    public Values createValues() {
        return new Values();
    }

    /**
     * Create an instance of {@link DataSize }
     * 
     */
    public DataSize createDataSize() {
        return new DataSize();
    }

    /**
     * Create an instance of {@link DatasetType }
     * 
     */
    public DatasetType createDatasetType() {
        return new DatasetType();
    }

    /**
     * Create an instance of {@link ControlledVocabulary }
     * 
     */
    public ControlledVocabulary createControlledVocabulary() {
        return new ControlledVocabulary();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link Aggregation }
     * 
     */
    public Aggregation createAggregation() {
        return new Aggregation();
    }

    /**
     * Create an instance of {@link Namer }
     * 
     */
    public Namer createNamer() {
        return new Namer();
    }

    /**
     * Create an instance of {@link Access }
     * 
     */
    public Access createAccess() {
        return new Access();
    }

    /**
     * Create an instance of {@link AddID }
     * 
     */
    public AddID createAddID() {
        return new AddID();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link UserImplType }
     * 
     */
    public UserImplType createUserImplType() {
        return new UserImplType();
    }

    /**
     * Create an instance of {@link TimeCoverageType }
     * 
     */
    public TimeCoverageType createTimeCoverageType() {
        return new TimeCoverageType();
    }

    /**
     * Create an instance of {@link FilterSelectorType }
     * 
     */
    public FilterSelectorType createFilterSelectorType() {
        return new FilterSelectorType();
    }

    /**
     * Create an instance of {@link Dimension }
     * 
     */
    public Dimension createDimension() {
        return new Dimension();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link Contributor }
     * 
     */
    public Contributor createContributor() {
        return new Contributor();
    }

    /**
     * Create an instance of {@link DateTypeFormatted }
     * 
     */
    public DateTypeFormatted createDateTypeFormatted() {
        return new DateTypeFormatted();
    }

    /**
     * Create an instance of {@link SpatialRange }
     * 
     */
    public SpatialRange createSpatialRange() {
        return new SpatialRange();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createSourceTypeContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamerSelectorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "regExpOnPath", scope = Namer.class)
    public JAXBElement<NamerSelectorType> createNamerRegExpOnPath(NamerSelectorType value) {
        return new JAXBElement<NamerSelectorType>(_NamerRegExpOnPath_QNAME, NamerSelectorType.class, Namer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamerSelectorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "regExpOnName", scope = Namer.class)
    public JAXBElement<NamerSelectorType> createNamerRegExpOnName(NamerSelectorType value) {
        return new JAXBElement<NamerSelectorType>(_NamerRegExpOnName_QNAME, NamerSelectorType.class, Namer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatasetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "dataset")
    public JAXBElement<DatasetType> createDataset(DatasetType value) {
        return new JAXBElement<DatasetType>(_Dataset_QNAME, DatasetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "catalogRef", substitutionHeadNamespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", substitutionHeadName = "dataset")
    public JAXBElement<CatalogRef> createCatalogRef(CatalogRef value) {
        return new JAXBElement<CatalogRef>(_CatalogRef_QNAME, CatalogRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatasetFmrc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "datasetFmrc", substitutionHeadNamespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", substitutionHeadName = "dataset")
    public JAXBElement<DatasetFmrc> createDatasetFmrc(DatasetFmrc value) {
        return new JAXBElement<DatasetFmrc>(_DatasetFmrc_QNAME, DatasetFmrc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatasetScan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "datasetScan", substitutionHeadNamespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", substitutionHeadName = "dataset")
    public JAXBElement<DatasetScan> createDatasetScan(DatasetScan value) {
        return new JAXBElement<DatasetScan>(_DatasetScan_QNAME, DatasetScan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterSelectorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "include", scope = Filter.class)
    public JAXBElement<FilterSelectorType> createFilterInclude(FilterSelectorType value) {
        return new JAXBElement<FilterSelectorType>(_FilterInclude_QNAME, FilterSelectorType.class, Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterSelectorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "exclude", scope = Filter.class)
    public JAXBElement<FilterSelectorType> createFilterExclude(FilterSelectorType value) {
        return new JAXBElement<FilterSelectorType>(_FilterExclude_QNAME, FilterSelectorType.class, Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ControlledVocabulary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "keyword", scope = DatasetType.class)
    public JAXBElement<ControlledVocabulary> createDatasetTypeKeyword(ControlledVocabulary value) {
        return new JAXBElement<ControlledVocabulary>(_DatasetTypeKeyword_QNAME, ControlledVocabulary.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "dataType", scope = DatasetType.class)
    public JAXBElement<String> createDatasetTypeDataType(String value) {
        return new JAXBElement<String>(_DatasetTypeDataType_QNAME, String.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "authority", scope = DatasetType.class)
    public JAXBElement<String> createDatasetTypeAuthority(String value) {
        return new JAXBElement<String>(_DatasetTypeAuthority_QNAME, String.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ControlledVocabulary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "project", scope = DatasetType.class)
    public JAXBElement<ControlledVocabulary> createDatasetTypeProject(ControlledVocabulary value) {
        return new JAXBElement<ControlledVocabulary>(_DatasetTypeProject_QNAME, ControlledVocabulary.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "publisher", scope = DatasetType.class)
    public JAXBElement<SourceType> createDatasetTypePublisher(SourceType value) {
        return new JAXBElement<SourceType>(_DatasetTypePublisher_QNAME, SourceType.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "creator", scope = DatasetType.class)
    public JAXBElement<SourceType> createDatasetTypeCreator(SourceType value) {
        return new JAXBElement<SourceType>(_DatasetTypeCreator_QNAME, SourceType.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "serviceName", scope = DatasetType.class)
    public JAXBElement<String> createDatasetTypeServiceName(String value) {
        return new JAXBElement<String>(_DatasetTypeServiceName_QNAME, String.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTypeFormatted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "date", scope = DatasetType.class)
    public JAXBElement<DateTypeFormatted> createDatasetTypeDate(DateTypeFormatted value) {
        return new JAXBElement<DateTypeFormatted>(_DatasetTypeDate_QNAME, DateTypeFormatted.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "timeCoverage", scope = DatasetType.class)
    public JAXBElement<TimeCoverageType> createDatasetTypeTimeCoverage(TimeCoverageType value) {
        return new JAXBElement<TimeCoverageType>(_DatasetTypeTimeCoverage_QNAME, TimeCoverageType.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "dataFormat", scope = DatasetType.class)
    public JAXBElement<String> createDatasetTypeDataFormat(String value) {
        return new JAXBElement<String>(_DatasetTypeDataFormat_QNAME, String.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "documentation", scope = DatasetType.class)
    public JAXBElement<DocumentationType> createDatasetTypeDocumentation(DocumentationType value) {
        return new JAXBElement<DocumentationType>(_DatasetTypeDocumentation_QNAME, DocumentationType.class, DatasetType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ControlledVocabulary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "keyword", scope = Metadata.class)
    public JAXBElement<ControlledVocabulary> createMetadataKeyword(ControlledVocabulary value) {
        return new JAXBElement<ControlledVocabulary>(_DatasetTypeKeyword_QNAME, ControlledVocabulary.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "dataType", scope = Metadata.class)
    public JAXBElement<String> createMetadataDataType(String value) {
        return new JAXBElement<String>(_DatasetTypeDataType_QNAME, String.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "authority", scope = Metadata.class)
    public JAXBElement<String> createMetadataAuthority(String value) {
        return new JAXBElement<String>(_DatasetTypeAuthority_QNAME, String.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ControlledVocabulary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "project", scope = Metadata.class)
    public JAXBElement<ControlledVocabulary> createMetadataProject(ControlledVocabulary value) {
        return new JAXBElement<ControlledVocabulary>(_DatasetTypeProject_QNAME, ControlledVocabulary.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "serviceName", scope = Metadata.class)
    public JAXBElement<String> createMetadataServiceName(String value) {
        return new JAXBElement<String>(_DatasetTypeServiceName_QNAME, String.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "publisher", scope = Metadata.class)
    public JAXBElement<SourceType> createMetadataPublisher(SourceType value) {
        return new JAXBElement<SourceType>(_DatasetTypePublisher_QNAME, SourceType.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "creator", scope = Metadata.class)
    public JAXBElement<SourceType> createMetadataCreator(SourceType value) {
        return new JAXBElement<SourceType>(_DatasetTypeCreator_QNAME, SourceType.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTypeFormatted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "date", scope = Metadata.class)
    public JAXBElement<DateTypeFormatted> createMetadataDate(DateTypeFormatted value) {
        return new JAXBElement<DateTypeFormatted>(_DatasetTypeDate_QNAME, DateTypeFormatted.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "timeCoverage", scope = Metadata.class)
    public JAXBElement<TimeCoverageType> createMetadataTimeCoverage(TimeCoverageType value) {
        return new JAXBElement<TimeCoverageType>(_DatasetTypeTimeCoverage_QNAME, TimeCoverageType.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "dataFormat", scope = Metadata.class)
    public JAXBElement<String> createMetadataDataFormat(String value) {
        return new JAXBElement<String>(_DatasetTypeDataFormat_QNAME, String.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "documentation", scope = Metadata.class)
    public JAXBElement<DocumentationType> createMetadataDocumentation(DocumentationType value) {
        return new JAXBElement<DocumentationType>(_DatasetTypeDocumentation_QNAME, DocumentationType.class, Metadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTypeFormatted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "start", scope = TimeCoverageType.class)
    public JAXBElement<DateTypeFormatted> createTimeCoverageTypeStart(DateTypeFormatted value) {
        return new JAXBElement<DateTypeFormatted>(_TimeCoverageTypeStart_QNAME, DateTypeFormatted.class, TimeCoverageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "duration", scope = TimeCoverageType.class)
    public JAXBElement<String> createTimeCoverageTypeDuration(String value) {
        return new JAXBElement<String>(_TimeCoverageTypeDuration_QNAME, String.class, TimeCoverageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTypeFormatted }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unidata.ucar.edu/namespaces/thredds/InvCatalog/v1.0", name = "end", scope = TimeCoverageType.class)
    public JAXBElement<DateTypeFormatted> createTimeCoverageTypeEnd(DateTypeFormatted value) {
        return new JAXBElement<DateTypeFormatted>(_TimeCoverageTypeEnd_QNAME, DateTypeFormatted.class, TimeCoverageType.class, value);
    }

}
