package com.example.application.views.datepickerview;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Date Picker View")
@Route(value = "date-picker-view")
@RouteAlias(value = "")
public class DatePickerView extends VerticalLayout {

    /**
     * Tasks to complete:
     *
     * 1.
     * 1.1. Create a page where users can enter events that happened during World War 1.
     * 1.2. Each event should have a name and a date.
     * 1.3. The events should be displayed in a Grid.
     * 1.4. Make sure that the entered dates with 2-digit years are interpreted as dates related
     *      to World War 1 events (1914-1918).
     *
     * 2.
     * 2.1. A 4-digits year presentation is superfluous in this context. As a follow-up,
     *      modify the page in order to display the year values using 2 digits.
     * 2.2. Modify the page in order to accept only dates with 2-digit years.
     *
     * 3.
     * 3.1. Try entering dates between 0-99 with and without zero padding in a date picker
     *      with short year format
     * 3.2. Try entering dates between 0-999 with and without zero padding in a date picker
     *      with 4-digit year format or locale
     *
     */
    public DatePickerView() {
    }
}
