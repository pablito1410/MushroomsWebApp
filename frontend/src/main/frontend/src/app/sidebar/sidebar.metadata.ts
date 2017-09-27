
/**
 * Menu type
 */
export enum MenuType {
    BRAND,
    LEFT,
    RIGHT
}

/**
 * Route info
 */
export interface RouteInfo {
    path: string;
    title: string;
    menuType: MenuType;
    icon: string;
}
