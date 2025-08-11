from selenium import webdriver
from selenium.webdriver.support.ui import Select
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
import time

# Setup WebDriver
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))

# Open the page
driver.get("https://training-support.net/webelements/selects")

# Verify the page title
print("Page title is:", driver.title)

# Locate the select element
select_element = driver.find_element(By.CSS_SELECTOR, "select.h-80")
multi_select = Select(select_element)

# Select "HTML" using visible text
multi_select.select_by_visible_text("HTML")

# Select 4th, 5th, and 6th options (index starts from 0)
for i in range(3, 6):
    multi_select.select_by_index(i)

# Select "NodeJS" using value attribute
multi_select.select_by_value("nodejs")

# Print selected options
selected_options = multi_select.all_selected_options
print("Selected options are:")
for option in selected_options:
    print(option.text)

# Deselect 5th index (index = 4)
multi_select.deselect_by_index(4)

# Print selected options again
selected_options = multi_select.all_selected_options
print("Selected options after deselecting index 4:")
for option in selected_options:
    print(option.text)

# Close the browser
driver.quit()