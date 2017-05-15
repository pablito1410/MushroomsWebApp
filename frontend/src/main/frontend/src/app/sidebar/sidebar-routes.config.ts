import { MenuType, RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
    { path: 'dashboard', title: 'Dashboard', menuType: MenuType.LEFT, icon: 'material-icons' },
    { path: 'user', title: 'User profile', menuType: MenuType.LEFT, icon: 'material-icons' },
    { path: 'trips', title: 'Trips', menuType: MenuType.LEFT, icon: 'material-icons' },
    { path: 'discoveries', title: 'Discoveries', menuType: MenuType.LEFT, icon: 'material-icons' },
    { path: 'friends', title: 'Friends', menuType: MenuType.LEFT, icon:'material-icons' },
    { path: 'notifications', title: 'Notifications', menuType: MenuType.LEFT, icon: 'material-icons text-gray' },
    { path: 'maps', title: 'Maps', menuType: MenuType.LEFT, icon: 'material-icons' }
];
