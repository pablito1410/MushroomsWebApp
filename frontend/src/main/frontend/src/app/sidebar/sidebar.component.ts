import { Component, OnInit } from '@angular/core';
import { ROUTES } from './sidebar-routes.config';
import { MenuType } from './sidebar.metadata';

declare var $:any;

/**
 * Sidebar component
 */
@Component({
    moduleId: module.id,
    selector: 'sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})
export class SidebarComponent implements OnInit {

    /** Array with menu items */
    public menuItems: any[];

    /**
     * Initialization method
     */
    ngOnInit() {
        $.getScript('../../assets/js/material-dashboard-angular.js');
        this.menuItems = ROUTES.filter(menuItem => menuItem.menuType !== MenuType.BRAND);
    }
}
