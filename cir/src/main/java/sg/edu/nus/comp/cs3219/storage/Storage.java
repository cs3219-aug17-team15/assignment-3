package sg.edu.nus.comp.cs3219.storage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
  // to be changed to unparsed and parsed only
  public static final String ASSET_BASE_PATH_XML = "/assets/XML";
//  public static final String ASSET_BASE_PATH_JSON = "/assets/JSON";
  public static final String ASSET_BASE_PATH_PARSED = "/assets/parsed";

  private File xmlDir;
//  private File jsonDir;

  public Storage() {
    Path currPath = Paths.get(".");
    Path xmlFilePath = Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_XML);
//    Path jsonFilePath = Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_JSON);

    xmlDir = new File(xmlFilePath.toString());
    if (!xmlDir.exists()) {
      xmlDir.mkdirs();
    }
//
//    jsonDir = new File(jsonFilePath.toString());
//    if (!jsonDir.exists()) {
//      jsonDir.mkdirs();
//    }
  }

  public File getAssetBaseDir() {
    return xmlDir;
  }

  public File getConferenceDir(String conference) {
    return new File(Paths.get(xmlDir.getPath().toString(), conference).toString());
  }

  public File getConferenceWithYearDir(String conference, int year) {
    String folder = conference + Integer.toString(year);
    if (year > 2000) {
      folder = conference + Integer.toString(year - 2000);
    }
    Path path = Paths.get(xmlDir.getPath().toString(), conference, folder);
    return new File(path.toString());
  }

  public List<File> getConferenceThroughYearsDir(String conference, int from, int to) {
    List<File> res = new ArrayList<File>();
    for (int i = from; i <= to; i++) {
      File dir = getConferenceWithYearDir(conference, i);
      res.add(dir);
    }
    return res;
  }

  // workaround until db is set up
  public void getBasePaper() {

  }

  public int getDocumentCount() {
    Path currPath = Paths.get(".");
    File xmlFiles = new File(Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_XML).toString());
//    File jsonFiles = new File(Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_JSON).toString());
    return countFilesInDirectory(xmlFiles); // + countFilesInDirectory(jsonFiles);
  }

  private int countFilesInDirectory(File directory) {
    int count = 0;
    for (File file : directory.listFiles()) {
      if (file.isFile()) {
        count++;
      }
      if (file.isDirectory()) {
        count += countFilesInDirectory(file);
      }
    }
    return count;
  }
}
