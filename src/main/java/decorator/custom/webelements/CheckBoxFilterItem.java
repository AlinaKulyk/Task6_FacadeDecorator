package decorator.custom.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxFilterItem extends AbstractElement {
    public CheckBoxFilterItem(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public void setChecked(boolean shouldBeChecked, long timeOutInSeconds) {
        WebElement input = element.findElement(By.xpath("input"));
        if ((input.isSelected() && !shouldBeChecked) || (!input.isSelected() && shouldBeChecked)) {
            safeAction(() -> element.click(), timeOutInSeconds);
        } else {
            System.out.println("Element is already checked");
        }
    }

    public void setCheckedThenWaitForUpdate(
        boolean shouldBeChecked,
        WebElement elemenToWaitFortUpdate,
        long timeOutInSeconds
    ) {
        performAndWaitForUpdate(driver, () -> setChecked(shouldBeChecked, timeOutInSeconds), elemenToWaitFortUpdate, timeOutInSeconds);
    }

}
