package config.comparitor

import com.brovada.policychange.service.comparitor.SimpleXmlUnitSelector
import com.brovada.policychange.service.comparitor.XmlUnitUtils

def buildSelectors() {
    List<SimpleXmlUnitSelector> selectors = new ArrayList<>()

    selectors.add(new SimpleXmlUnitSelector("OtherOrPriorPolicy", [], ["PolicyNumber"]))

    return XmlUnitUtils.buildDocumentSelector(selectors)
}

Set<String> addToWhiteList() {
    return [

    ]
}

Set<String> addToBlackList() {
    return [

    ]
}

Set<String> ignoredXpaths() {
    return [

    ]
}