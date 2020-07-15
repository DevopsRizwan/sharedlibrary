package org.devopsgate


import static groovy.json.JsonOutput.*

  class Build implements  Serializable {
	
  def steps
  Build(steps) {this.steps = steps}

/**
* Builds by using default Maven tool
*
* @param mvnPath -path of the projects pom.xml file 
*/
  def buildMvn( mvnPath ) {
    steps.sh "echo ${mvnPath}"
  }

/**
* Build Node modules and install prebuild requisites 
*
* @param nodePath path where node modules need to be build
*/
 


}