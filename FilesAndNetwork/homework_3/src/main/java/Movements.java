import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    String comma = ",";
    String quote = "\"";
    String slash = "[\\/\\\\]";
    Pattern pattern = Pattern.compile(slash);
    List<Operation> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                if (line.equals(lines.get(0))) {
                    continue;
                }
                String[] fragments = line
                        .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fragments.length != 8) {
                    for (String fragment : fragments) {
                        System.out.println(fragment);
                    }
                    System.out.println("WRONG LINE: " + line);
                    continue;
                }
                movements.add(new Operation(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        Double.parseDouble(fragments[6].replaceAll(comma, ".")
                                .replaceAll(quote, "")),
                        Double.parseDouble(fragments[7].replaceAll(comma, ".")
                                .replaceAll(quote, "")
                        )));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (Operation movement : movements) {
            expenseSum = expenseSum + movement.getRashod();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (Operation movement : movements) {
            incomeSum = incomeSum + movement.getPrihod();
        }
        return incomeSum;
    }

    public void listOperations() {
        for (Operation operation :
                movements) {
            Matcher matcher = pattern.matcher(operation.getOpDiscpription());
            matcher.find();
            int start = matcher.start();
            int end = operation.getOpDiscpription().indexOf("  ", start);
            System.out.println(operation.getOpDiscpription().
                    substring(start, end) + "                   " + operation.getRashod());
        }
    }
}
