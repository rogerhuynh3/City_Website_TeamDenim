import csv

class WeatherStation:
    def __init__(self):
        self.weather_data = []

    def submit_data(self, temperature, humidity, pressure):
        data = {
            "temperature": temperature,
            "humidity": humidity,
            "pressure": pressure
        }
        self.weather_data.append(data)
        print("Data submitted successfully")

    def get_data(self):
        return self.weather_data

    def export_data(self, filename):
        with open(filename, 'w', newline='') as csvfile:
            fieldnames = ['temperature', 'humidity', 'pressure']  # Specify fieldnames here
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()
            for data in self.weather_data:
                writer.writerow(data)

    def analyze_data(self):
        if not self.weather_data:
            print("No data available for analysis")
            return

        total_temperature = sum(data['temperature'] for data in self.weather_data)
        total_humidity = sum(data['humidity'] for data in self.weather_data)
        total_pressure = sum(data['pressure'] for data in self.weather_data)
        num_entries = len(self.weather_data)

        average_temperature = total_temperature / num_entries
        average_humidity = total_humidity / num_entries
        average_pressure = total_pressure / num_entries

        print(f"Average Temperature: {average_temperature}")
        print(f"Average Humidity: {average_humidity}")
        print(f"Average Pressure: {average_pressure}")
