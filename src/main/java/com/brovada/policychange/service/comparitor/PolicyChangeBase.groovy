package com.brovada.policychange.service.comparitor

import org.codehaus.groovy.control.CompilerConfiguration
import org.xmlunit.diff.Diff

class PolicyChangeBase extends Script {

    def _oldXml
    def _newXml

    def setOldXml(oldXml) {
        _oldXml = oldXml
    }

    def setNewXml(newXml) {
        _newXml = newXml
    }

    def exec() {
        println 'executing pch comparison...'

        def blackList = addToBlackList()
        def whiteList = addToWhiteList()
        def ignoredXpaths = ignoredXpaths()

        Diff myDiff = doCompare(buildSelectors(), addNodeFilter(blackList, whiteList))

        def resultManifest = generateManifest(myDiff, ignoredXpaths)

        return resultManifest
    }

    def run() {

    }

    def init(scriptPath, oldXml, newXml) {

        CompilerConfiguration cfg = new CompilerConfiguration()
        cfg.setScriptBaseClass this.getClass().getName()
        GroovyClassLoader gcl = new GroovyClassLoader(this.class.getClassLoader(), cfg)
        gcl.clearCache()
        File scriptFile = new File(scriptPath)
        def wfClass = gcl.parseClass(scriptFile)
        PolicyChangeBase implObj = wfClass.newInstance()
        implObj.setOldXml(oldXml)
        implObj.setNewXml(newXml)

        implObj.run()
        def result = implObj.exec()

        return result
    }

    def buildSelectors() {
    }

    def addNodeFilter(blackList, whiteList) {
        return XmlUnitUtils.addNodeFilter(blackList, whiteList)
    }

    def doCompare(selector, nodeFilter) {
        return XmlUnitUtils.doCompare(_oldXml, _newXml, selector, nodeFilter)
    }

    def generateManifest(diff, ignoredXpaths) {
        return XmlUnitUtils.generateManifest(diff, ignoredXpaths)
    }

    Set<String> addToWhiteList() {
        return []
    }

    Set<String> addToBlackList() {
        return []
    }

    Set<String> ignoredXpaths() {
        return []
    }

}