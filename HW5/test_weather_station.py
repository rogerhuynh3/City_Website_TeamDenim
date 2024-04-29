# test_weather_station.py

import pytest
import os
from weather_station import WeatherStation

@pytest.fixture
def weather_station():
    return WeatherStation()

def test_submit_data(weather_station):
    weather_station.submit_data(25.0, 60.0, 1013.25)
    assert len(weather_station.weather_data) == 1
    assert weather_station.weather_data[0]['temperature'] == 25.0
    assert weather_station.weather_data[0]['humidity'] == 60.0
    assert weather_station.weather_data[0]['pressure'] == 1013.25

def test_export_data(weather_station):
    weather_station.submit_data(25.0, 60.0, 1013.25)
    weather_station.submit_data(26.0, 65.0, 1014.25)
    filename = 'test_data.csv'
    weather_station.export_data(filename)
    assert os.path.exists(filename)
    os.remove(filename)

def test_analyze_data(weather_station, capsys):
    weather_station.submit_data(25.0, 60.0, 1013.25)
    weather_station.submit_data(26.0, 65.0, 1014.25)
    weather_station.analyze_data()
    captured = capsys.readouterr()
    assert "Average Temperature: 25.5" in captured.out
    assert "Average Humidity: 62.5" in captured.out
    assert "Average Pressure: 1013.75" in captured.out
