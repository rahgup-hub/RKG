import groovy.io.FileType

def folder = "D:\\installations\\groovy-2.4.13\\bin";
def dir = new File(folder);
def filelist = []
dir.eachFileRecurse (FileType.FILES) {
 file -> filelist << file
}

filelist.each {
  println it.path
}