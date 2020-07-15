import org.devopsgate.*
/*def build_ci (String buildType)

{
 println "$buildType"

}
*/

def call(Map param){

def buildfun = new Build(this)

buildfun.buildMvn("${param.mvnPath}")

}

/*
def build_cd(buildType){
 println "$buildType"
}
*/
