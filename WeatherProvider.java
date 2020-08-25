import java.util.Random;

public class WeatherProvider {

	private static double temperatureForToday = generateTemperature();
    private static double[] temperaturesFor10Days = generateTemperaturesForecastFor10Days();

    private static double generateTemperature() {
        Random rd = new Random(); 
        double temperature = 300 * ( rd.nextDouble() - 0.5 );
        return temperature;
    }

    private static double[] generateTemperaturesForecastFor10Days() {
    	double[] forecastArray = new double[10];
		for (int i = 0; i < forecastArray.length; i++) {
			forecastArray[i] = generateTemperature();
		}
		return forecastArray;
	}


    public static double getTemperatureForToday() {
		return temperatureForToday;
      
    }

    public static double[] getTemperaturesForecastFor10Days() {
		return temperaturesFor10Days;
       
    }

    public static double calculateAvgFor10Days() {
    	double avgTemp10Days = 0;
		for (int i = 0; i < temperaturesFor10Days.length; i++) {
			avgTemp10Days += temperaturesFor10Days[i];
		}
		return avgTemp10Days / temperaturesFor10Days.length;
	}

    public static double getMaxTemperatureFor10Days() {
    	double maxTemp10Days = temperaturesFor10Days[0];
		for (int i = 1; i < temperaturesFor10Days.length; i++) {
			if (maxTemp10Days >= temperaturesFor10Days[i]) {
				continue;
			}
			maxTemp10Days = temperaturesFor10Days[i];
		}
		return maxTemp10Days;
	}

    public static double getMinTemperatureFor10Days() {
    	double minTemp10Days = temperaturesFor10Days[0];
		for (int i = 1; i < temperaturesFor10Days.length; i++) {
			if (minTemp10Days <= temperaturesFor10Days[i]) {
				continue;
			}
			minTemp10Days = temperaturesFor10Days[i];
		}
		return minTemp10Days;
	}
}
