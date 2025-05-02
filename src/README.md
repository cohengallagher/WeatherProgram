# Weather Program - JavaFX Desktop Application
### By: Cohen Gallagher
### Date: 05/02/2025
## Overview
The weather program I build is a desktop application built in Java using JavaFX
and SceneBuilder. This application features a styled and responsive graphical interface
with a built-in driver class for a console version as well.

## Functionality 
Upon launching the application, users are presented with a clean interface
that was styled in SceneBuilder using CSS. The user enters a ZIP code and selects
preferred units of measure using radio buttons - Celsius or Fahrenheit for temperature,
millimeters or inches for percipitation, and kilometers per hour or miles per hour for wind
speed. When the user clicks the "Check Weather" button, the application validates the ZIP code,
fetches the appropriate location data, and then requests current weather data from Open-Meteo.
It then updates the labels with the information pulled from the API, and converts the data according 
to the user's selected units. 

Additionally, the application updates the background image according to the weather code. Clear skies
triggers a sunset with a sun image, while stormy weather will cause a thunderstorm image to reveal itself.
A reset button is also available to quickly clear all the fields.

The backend logic is separated into many helped classes. ZipcodeConverter fetches geolocation
data based on the ZIP code provided. WeatherFetcher handles all communication with the Open-Meteo
weather API. The WeatherData and LocationData classes serve as models to encapsulate relevant data.
A UnitConverter is used for switching between metric and imperial values. The Validator class
ensure ZIP codes meet necessary requirements before API calls are made, and they also handle some 
validation for the console application. The WeatherController handles all logic between the user interface
and these backend helper classes.

## Purpose
This project was built as my final project for my Programming in Java class. It was used to develop
our understanding of JavaFX, APIs, and event-driven programming. It also served as a practical exercise in separating logic,
validation, and user interface responsibilities. I really wanted to focus on making it very visually appealing. I had a 
great time combining both frontend and backend logic. This project was a great way to understand APIs in Java and it used
a real-world use case.

## How to Run
To run this application, ensure that you have JavaFX installed and configured. You can launch it through an
IDE like IntelliJ using VM options that point to your JavaFX SDK. You must also ensure your resource
folders are correctly marked so the application can find the necessary images and
FXML files.