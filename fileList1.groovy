import static groovy.io.FileType.FILES;

def folder = "D:\\projects\\work\\groovy\\soapresults";
def dir = new File(folder);
def filelist = [];
dir.traverse(type: FILES, maxDepth: 0) { filelist.add(it) };
println "FIRS FILE:"+filelist[0];

println "List:"+filelist[0];