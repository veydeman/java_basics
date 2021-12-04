import java.util.Random;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patient = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
//            float x = (float) (Math.random() * ((40 - 32) + 0.0000000000000000000001 + 32));
            Random random = new Random();
            float x = random.nextFloat() * (40 - 32) + 32;
            patient[i] = x;
        }
        return patient;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float meanTemp = 0;
        int healthy = 0;
        String temperature = "";

        for (int i = 0; i < temperatureData.length; i++) {
            meanTemp += temperatureData[i];
            if (temperatureData[i] >= (float) 36.2 & temperatureData[i] <= (float) 36.9) {
                healthy += 1;
            }
            if (i == temperatureData.length - 1) {
                temperature = temperature.concat(Float.toString(temperatureData[i]));
            }
            else {
                temperature = temperature.concat(Float.toString(temperatureData[i])).concat(" ");
            }
        }
        meanTemp = meanTemp / temperatureData.length;
        String result = String.format("%.2f", meanTemp);
        String report =
                "Температуры пациентов: " + temperature +
                        "\nСредняя температура: " + result +
                        "\nКоличество здоровых: " + healthy;


        return report;
    }
}
