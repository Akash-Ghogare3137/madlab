import numpy as np
import matplotlib.pyplot as plt
from scipy import stats

# Data
years_worked = np.array([1, 2, 3, 4, 5, 6, 7, 8])
cakes_made = np.array([5, 6500, 7805, 6000, 10835, 11230, 15870, 16387])

# Scatter plot
plt.scatter(years_worked, cakes_made, color='blue', label='Data Points')

# Calculate line of best fit
slope, intercept, r_value, p_value, std_err = stats.linregress(years_worked, cakes_made)
line_of_best_fit = slope * years_worked + intercept

# Plot line of best fit
plt.plot(years_worked, line_of_best_fit, color='red', label=f'Line of Best Fit: y={slope:.2f}x + {intercept:.2f}')

# Add labels and title
plt.xlabel('Years Worked')
plt.ylabel('Cakes Made')
plt.title('Years Worked vs Cakes Made')
plt.legend()
plt.show()

# Correlation coefficient
correlation_coefficient = r_value

# Equation of the line
equation_of_line = f"y = {slope:.2f}x + {intercept:.2f}"

# Prediction for 10 years
years_predict = 10
cakes_predict = slope * years_predict + intercept

print(f"Correlation Coefficient (r): {correlation_coefficient:.2f}")
print("Type of Correlation:", "Positive" if correlation_coefficient > 0 else "Negative" if correlation_coefficient < 0 else "None")
print(f"Equation of the line: {equation_of_line}")
print(f"Predicted number of Crabby Cakes after 10 years: {cakes_predict:.2f}")


