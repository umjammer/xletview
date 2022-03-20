

package net.beiker.xletview.download;
import java.io.File;

/**
 *
 * @author Martin Sveden
 *
 */
public class RelFile {

    private File file;
    private String relPath;

    public RelFile(File file, String relPath){
        this.file = file;
        this.relPath = relPath;
    }

    public File getFile(){
        return file;
    }

    public String getRelPath(){
        return relPath;
    }

}
