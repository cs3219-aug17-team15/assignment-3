package sg.edu.nus.comp.cs3219.storage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
  // to be changed to unparsed and parsed only
  public static final String ASSET_BASE_PATH_XML = "/assets/XML";
  // public static final String ASSET_BASE_PATH_JSON = "/assets/JSON";
  public static final String ASSET_BASE_PATH_PARSED = "/assets/parsed";

  private File xmlDir;
  // private File jsonDir;

  public Storage() {
    Path currPath = Paths.get(".");
    Path xmlFilePath = Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_XML);
    // Path jsonFilePath = Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_JSON);

    xmlDir = new File(xmlFilePath.toString());
    if (!xmlDir.exists()) {
      xmlDir.mkdirs();
    }
    //
    // jsonDir = new File(jsonFilePath.toString());
    // if (!jsonDir.exists()) {
    // jsonDir.mkdirs();
    // }
  }

  public File getAssetBaseDir() {
    return xmlDir;
  }

  // used to get conference base or specific conference e.g. D12
  public File getConferenceDir(String conference) {
    File dir;
    if (conference.matches(".*\\d+.*")) {
      dir = new File(Paths.get(xmlDir.getPath().toString(),
          conference.toUpperCase().substring(0, 1), conference).toString());
    } else {
      dir = new File(Paths.get(xmlDir.getPath().toString(), conference.toUpperCase()).toString());
    }
    if (!dir.exists()) {
      dir.mkdirs();
    }
    return dir;
  }

  // used when conference is only letter, e.g. D
  public File getConferenceWithYearDir(String conference, int year) {
    if (conference.length() > 1) {
      return getConferenceDir(conference);
    }

    String yrString = Integer.toString(year);
    if (yrString.length() == 4) {
      yrString = yrString.substring(2);
    }
    String folder = conference.toUpperCase() + yrString;
    Path path = Paths.get(xmlDir.getPath().toString(), conference.toUpperCase(), folder);
    File dir = new File(path.toString());
    if (!dir.exists()) {
      dir.mkdirs();
    }
    return dir;
  }

  public List<File> getConferenceThroughYearsDir(String conference, int from, int to) {
    List<File> res = new ArrayList<File>();
    for (int i = from; i <= to; i++) {
      File dir = getConferenceWithYearDir(conference, i);
      res.add(dir);
    }
    return res;
  }

  public int getDocumentCount() {
    Path currPath = Paths.get(".");
    File xmlFiles =
        new File(Paths.get(currPath.toString(), Storage.ASSET_BASE_PATH_XML).toString());
    // File jsonFiles = new File(Paths.get(currPath.toString(),
    // Storage.ASSET_BASE_PATH_JSON).toString());
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
