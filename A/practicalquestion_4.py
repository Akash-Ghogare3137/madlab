import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression

# Load the data
data = pd.read_csv('Car_data.csv')

# Print the DataFrame to inspect its contents
print("DataFrame Head:")
print(data.head())

print("\nDataFrame Columns:")
print(data.columns)

# Ensure there are no leading/trailing spaces in column names
data.columns = data.columns.str.strip()

# Check for missing values and handle them if necessary
print("\nMissing Values in Each Column:")
print(data.isnull().sum())

# Define the independent variables (features) and the dependent variable (target)
X = data[['Volume', 'Weight']]
y = data['CO2']

# Initialize and fit the multiple linear regression model
model = LinearRegression()
model.fit(X, y)

# Define the input values for prediction
volume = 1300
weight = 3300
# Create a DataFrame for the input data
input_data = pd.DataFrame({'Volume': [volume], 'Weight': [weight]})

# Predict the CO2 emission level
predicted_co2 = model.predict(input_data)

# Output the prediction
print(f"\nPredicted CO2 emission level for car with Volume = {volume} and Weight = {weight} is: {predicted_co2[0]:.2f} g/km")
