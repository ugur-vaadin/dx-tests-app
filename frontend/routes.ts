import { Flow } from 'Frontend/generated/jar-resources/Flow.js';
import { Route } from '@vaadin/router';
import './views/main-layout';

const { serverSideRoutes } = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports'),
});

export type ViewRoute = Route & {
  title?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  {
    path: 'date-picker-view-ts',
    component: 'date-picker-view',
    title: 'Date Picker View (Hilla)',
    action: async (_context, _command) => {
      await import('./views/date-picker-view/date-picker-view');
      return;
    },
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-layout',
    children: [
      ...views,
      // for server-side, the next magic line sends all unmatched routes:
      ...serverSideRoutes, // IMPORTANT: this must be the last entry in the array
    ],
  },
];
