
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Application {

  public static void main(String[] args) {
    XSSFWorkbook wb = new XSSFWorkbook(); // XSSF: XML SpreadSheet Format
    XSSFSheet ws = wb.createSheet();

    Object[][] playerDetailsArray = createPlayerArray();

    creatHeaderRow(ws);

    // looping over 2D Array : playerDetailsArray
    // nested loop : one loop for the rows (players) , and other loop for the columns (fields of each player)
    int rowNumber = 1;
    for (Object[] player: playerDetailsArray) {
      Row row = ws.createRow(rowNumber);
      rowNumber++;

      // creating the cells of the row(player)
      int columnNumber = 0;
      for (Object field : player) {
        Cell cell = row.createCell(columnNumber);
        if (field instanceof  Integer){
          cell.setCellValue( (Integer) field);
        }else {
          cell.setCellValue( (String) field);
        }

        columnNumber++;
      }
    }

    try(FileOutputStream outputStream = new FileOutputStream("src/main/resources/playerWorkbook.xlsx")) {
      wb.write(outputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void creatHeaderRow(XSSFSheet ws) {
    Row row = ws.createRow(0);
    List<String> headers = Arrays.asList("Name", "Age", "Games", "Goals", "Team", "League");

    for (int i = 0; i < headers.size(); i++) {
      Cell headerCell = row.createCell(i);
      headerCell.setCellValue(headers.get(i));
    }
  }

  private static Object[][] createPlayerArray() {
    // First Dimension List of players
    List<FootballPlayer> footballPlayers = createPlayersList();


    // playerDetailsArray:
    Object[][] playerDetailsArray = new Object[footballPlayers.size()][6];

    int playerIndexNumber = 0;
    for  (FootballPlayer player  :  footballPlayers  ) {
      playerDetailsArray[playerIndexNumber][0] = player.getName();
      playerDetailsArray[playerIndexNumber][1] = player.getAge();
      playerDetailsArray[playerIndexNumber][2] = player.getGoals();
      playerDetailsArray[playerIndexNumber][3] = player.getGames();
      playerDetailsArray[playerIndexNumber][4] = player.getTeam();
      playerDetailsArray[playerIndexNumber][5] = player.getLeague();

      playerIndexNumber++;
    }

    // last step in the method
    return playerDetailsArray;

  }

  private static List<FootballPlayer> createPlayersList() {
    List<FootballPlayer> playerList = new ArrayList<>();

    FootballPlayer player1 = new FootballPlayer("Adam",20,4,10,"team1","Premier");
    FootballPlayer player2 = new FootballPlayer("Bob",24,19,11,"team1","Premier");
    FootballPlayer player3 = new FootballPlayer("Charlie",25,2,10,"team1","Premier");
    FootballPlayer player4 = new FootballPlayer("Dean",28,1,10,"team1","Premier");
    FootballPlayer player5 = new FootballPlayer("Elias",33,0,9,"team1","Premier");
    FootballPlayer player6 = new FootballPlayer("Frazer",31,12,7,"team1","Premier");
    FootballPlayer player7 = new FootballPlayer("Grant",22,14,18,"team1","Premier");
    FootballPlayer player8 = new FootballPlayer("Harry",19,16,17,"team1","Premier");

    playerList.add(player1);
    playerList.add(player2);
    playerList.add(player3);
    playerList.add(player4);
    playerList.add(player5);
    playerList.add(player6);
    playerList.add(player7);
    playerList.add(player8);

    return playerList;
  }
}
