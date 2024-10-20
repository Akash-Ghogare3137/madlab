import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report

# Load the dataset
data = pd.read_csv('Bank_dataset_1.csv')

# Print the DataFrame to inspect its contents
print("DataFrame Head:")
print(data.head())

# Strip any leading/trailing spaces from column names
data.columns = data.columns.str.strip()

# Check for missing values
print("\nMissing Values in Each Column:")
print(data.isnull().sum())

# Define features and target variable
X = data.drop('Subscription', axis=1)  # Features
y = data['Subscription']                 # Target variable

# Identify categorical and numerical columns
categorical_cols = X.select_dtypes(include=['object']).columns
numerical_cols = X.select_dtypes(exclude=['object']).columns

# Preprocessing pipelines for both numeric and categorical data
numerical_transformer = StandardScaler()
categorical_transformer = OneHotEncoder(drop='first')  # Avoid dummy variable trap

# Create a column transformer to apply transformations
preprocessor = ColumnTransformer(
    transformers=[
        ('num', numerical_transformer, numerical_cols),
        ('cat', categorical_transformer, categorical_cols)
    ])

# Create a pipeline that first preprocesses the data then applies logistic regression
model = Pipeline(steps=[('preprocessor', preprocessor),
                        ('classifier', LogisticRegression(solver='liblinear'))])  # Use 'liblinear' for small datasets

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Fit the model
model.fit(X_train, y_train)

# Make predictions
y_pred = model.predict(X_test)

# Evaluate the model's performance
accuracy = accuracy_score(y_test, y_pred)
conf_matrix = confusion_matrix(y_test, y_pred)
class_report = classification_report(y_test, y_pred)

# Output the evaluation results
print(f"\nModel Accuracy: {accuracy:.2f}")
print("\nConfusion Matrix:")
print(conf_matrix)
print("\nClassification Report:")
print(class_report)

# Example prediction: predicting for a new customer
# You should only provide the features required for prediction, matching your X DataFrame
new_customer_data = np.array([[130,]])  # Example: Only 'duration' for prediction (130 seconds)

# Ensure the new data matches the feature columns
new_customer_df = pd.DataFrame(new_customer_data, columns=['duration'])  # Use the correct feature name

# Predict whether this new customer will subscribe
new_prediction = model.predict(new_customer_df)
print(f"\nNew Customer Subscription Prediction: {'Yes' if new_prediction[0] == 'yes' else 'No'}")
