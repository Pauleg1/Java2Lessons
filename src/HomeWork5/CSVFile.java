package HomeWork5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * Функциональные интерфейсы
 */
@FunctionalInterface
interface ConverterToInt {
    int[] convert(String[] array);
}

@FunctionalInterface
interface ConverterToStr {
    String[] convert(int[] array);
}

/**
 * Класс данных
 */
class AppData {
    private String[] headers;
    private int[][] data;
    final String SEPARATOR = ";";

    public AppData(int size, String headerLine, int[][] data) {
        this.headers = headerLine.split(",");
        this.data = data;
    }

    public AppData(String dump) {
        // конструктор объекта на основе CSV дампа,
        // предполагается, что данные корректны. Соответсвующую проверку не делаю, задача состоит не в этом.
        String[] csvData = dump.split("\n");
        this.headers = new String[csvData[0].split(SEPARATOR).length];
        this.data = new int[csvData.length - 1][this.headers.length];
        this.setCSVDump(dump);
    }

    public void setCSVDump(String dump) {   // распарсим и загрузим данные из дампа формата csv

        // анонимный конвертер строкового массива в целочисленный
        ConverterToInt converter = (array) -> {
            int[] res = new int[(array.length)];
            for (int j = 0; j < array.length; j++) {
                res[j]=Integer.valueOf(array[j]);
            }
            return res;
        };

        try {
            String[] csvData = dump.split("\n");
            this.headers = csvData[0].split(";");
            for (int i = 1; i < csvData.length; i++) {
                this.data[i-1]=converter.convert(csvData[i].split(SEPARATOR));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String getCSVDump(){     // вернем дамп из объекта в виде строки формата csv

        // анонимный конвертер числового массива в стоковый
        ConverterToStr converter = (array) -> {
            String[] res = new String[array.length];
            for (int j = 0; j < array.length; j++) {
                res[j]=Integer.toString(array[j]);
            }
            return res;
        };

        String[] dumpArr = new String[(this.data.length+1)];
        dumpArr[0] = String.join(SEPARATOR, this.headers);
        for (int i = 0; i < this.data.length; i++) {
            dumpArr[i+1] = String.join(SEPARATOR, converter.convert(this.data[i]));
        }
        String res = "";
        for (String s : dumpArr) {
            res+=s+'\n';
        }
        return res;
    }

}

/**
 * Главный класс программы
 */
public class CSVFile {
    final static String FILE = "file.csv";      // путь к файлу обмена
    final static String FILE1 = "file1.csv";      // путь к файлу для сравнения

    public static void saveToCSVFile(AppData data){
        // поскольку csv формат текстовый, то и работать с ним имеет смысл текстовыми средствами
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(data.getCSVDump());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static AppData loadFromCSVFile(String file){
        // загрузим данные в строку, и воспользуемя конструткором на основе scv дампа.
        String dump = "";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line=reader.readLine())!=null){
                dump+=line+'\n';
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        AppData data = new AppData(dump);
        return data;
    }

    public static void main(String[] args) {
        // создадим объект данных и сохраним его в файл
        int[][] array = {{100,200,123},{300,400,500},{600,700,11}};
        AppData data1 = new AppData(2,"Value 1,Value 2,Value 3",array);
        saveToCSVFile(data1);

        //Прочтем его из файла в другой объект, попутно создав его специальным конструктором
        AppData data2 = loadFromCSVFile(FILE);
        AppData data3 = loadFromCSVFile(FILE1);

        /* сравним имеющиеся объекты:
        для проверки равенства объктов в части хранимой ими информации достаточно сравнить строковые выражения в формате
        csv, а не писать метод проверки, если они окажутся равными, то и объекты хранят идентичную информацию
         */
        if (data1.getCSVDump().equals(data2.getCSVDump())) {
            System.out.println("Данные в выгруженом и загруженом объектах идентичны");
        } else {
            System.out.println("Данные в выгруженом и загруженом объектах различны");
        }
        // сравним неравные объекты
        if (data1.getCSVDump().equals(data3.getCSVDump())) {
            System.out.println("Данные в выгруженом и загруженом объектах идентичны");
        } else {
            System.out.println("Данные в выгруженом и загруженом объектах различны");
        }
    }
}
/*
Вывод программы :
    Данные в выгруженом и загруженом объектах идентичны
    Данные в выгруженом и загруженом объектах различны
*/
