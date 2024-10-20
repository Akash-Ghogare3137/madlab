import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression

# Load the data
data = pd.read_csv('Stock_data.csv')

# Print the DataFrame to inspect its contents
print("DataFrame Head:")
print(data.head())

print("\nDataFrame Columns:")
print(data.columns)

# Ensure there are no leading/trailing spaces in column names
data.columns = data.columns.str.strip()

# Verify the columns and their exact names
print("\nStripped DataFrame Columns:")
print(data.columns)

# Check if expected columns are present
expected_columns = ['interest_rate', 'unemployment_rate', 'stock_index_price']
missing_columns = [col for col in expected_columns if col not in data.columns]
if missing_columns:
    print(f"\nMissing Columns: {missing_columns}")
else:
    # Define the independent variables (features) and the dependent variable (target)
    X = data[['interest_rate', 'unemployment_rate']]
    y = data['stock_index_price']

    # Initialize and fit the multiple linear regression model
    model = LinearRegression()
    model.fit(X, y)

    # Define the input values for prediction
    interest_rate = 3
    unemployment_rate = 5.7
    input_data = np.array([[interest_rate, unemployment_rate]])

    # Predict the stock index price
    predicted_price = model.predict(input_data)

    # Output the prediction
    print(f"\nPredicted stock index price for interest rate = {interest_rate} and unemployment rate = {unemployment_rate} is: {predicted_price[0]:.2f}")
