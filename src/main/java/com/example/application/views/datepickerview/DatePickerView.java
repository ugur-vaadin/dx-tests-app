package com.example.application.views.datepickerview;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudI18n;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@PageTitle("Date Picker View")
@Route(value = "date-picker-view")
@RouteAlias(value = "")
public class DatePickerView extends VerticalLayout {

    /**
     * Tasks to complete:
     *
     * 1. Users can enter events that happened during World War 1. Each event has a name
     *      and a date. Make sure that the entered dates with 2-digit years are interpreted
     *      as dates related to World War 1 events (1914-1918).
     *
     * 2. Try entering a date with a year between 0-99.
     *
     */

    private Set<WorldWarEvent> events;

    public DatePickerView() {
        initWorldWarEvents();

        final Crud<WorldWarEvent> eventCrud = new Crud<>(WorldWarEvent.class, createWorldWarEventGrid(),
                createWorldWarEventBinderCrudEditor());
        eventCrud.setDataProvider(DataProvider.ofCollection(events));
        eventCrud.addSaveListener(e -> events.add(e.getItem()));
        eventCrud.addDeleteListener(e -> events.remove(e.getItem()));
        eventCrud.setEditOnClick(true);

        add(eventCrud);
    }

    private Grid<WorldWarEvent> createWorldWarEventGrid() {
        final Grid<WorldWarEvent> eventGrid = new Grid<>();
        eventGrid.addColumn(WorldWarEvent::getName).setHeader("Event");
        eventGrid.addColumn(WorldWarEvent::getDate).setHeader("Date");
        return eventGrid;
    }

    private BinderCrudEditor<WorldWarEvent> createWorldWarEventBinderCrudEditor() {
        final TextField eventNameField = new TextField("Event");
        final DatePicker eventDateField = new DatePicker("Date");
        final FormLayout form = new FormLayout(eventNameField, eventDateField);

        final Binder<WorldWarEvent> binder = new Binder<>(WorldWarEvent.class);
        binder.bind(eventNameField, WorldWarEvent::getName, WorldWarEvent::setName);
        binder.bind(eventDateField, WorldWarEvent::getDate, WorldWarEvent::setDate);

        return new BinderCrudEditor<>(binder, form);
    }

    private CrudI18n createCrudI18n() {
        final CrudI18n i18n = CrudI18n.createDefault();
        i18n.setNewItem("New event");
        i18n.setEditItem("Edit event");
        return i18n;
    }

    private void initWorldWarEvents() {
        events = new LinkedHashSet<>();
        events.add(new WorldWarEvent("Battle of Tannenberg", LocalDate.of(1914, 8, 26)));
        events.add(new WorldWarEvent("Battle of Verdun", LocalDate.of(1916, 2, 21)));
        events.add(new WorldWarEvent("The Treaty of Versailles", LocalDate.of(1919, 6, 28)));
    }
}
