import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../view';
import '@vaadin/crud';
import '@vaadin/vertical-layout';
import '@vaadin/date-picker';

type WorldWarEvent = { name: string; date: Date };
@customElement('date-picker-view')
export class DatePickerView extends View {

  /**
   * Tasks to complete:
   *
   * 1. Users can enter events that happened during World War 1. Each event has a name
   *      and a date. Make sure that the entered dates with 2-digit years are interpreted
   *      as dates related to World War 1 events (1914-1918).
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

  private events: WorldWarEvent[] = [];

  render() {
    return html`
      <vaadin-vertical-layout theme="padding">
        <vaadin-crud .items="${this.events}">
          <vaadin-grid slot="grid">
            <vaadin-grid-column path="name" auto-width="true" resizable="true"></vaadin-grid-column>
            <vaadin-grid-column path="date" auto-width="true" resizable="true"></vaadin-grid-column>
            <vaadin-crud-edit-column></vaadin-crud-edit-column>
          </vaadin-grid>
          <vaadin-form-layout slot="form">
            <vaadin-text-field label="Name" path="name"></vaadin-text-field>
            <vaadin-date-picker label="Date" path="date"></vaadin-date-picker>
          </vaadin-form-layout>
        </vaadin-crud>
      </vaadin-vertical-layout>
    `;
  }

  constructor() {
    super();

    this.events = [
      { name: 'Battle of Tannenberg', date: new Date(1914, 7, 26) },
      { name: 'Battle of Verdun', date: new Date(1916, 1, 21) },
      { name: 'The Treaty of Versailles', date: new Date(1919, 5, 28) },
    ];
  }
}
