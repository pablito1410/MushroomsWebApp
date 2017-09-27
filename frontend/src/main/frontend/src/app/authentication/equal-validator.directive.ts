import { Directive, forwardRef, Attribute } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

/**
 * Directive to validate equality of values from input
 * e.g. password and retype password
 */
@Directive({
    selector: '[validateEqual][formControlName],[validateEqual][formControl],[validateEqual][ngModel]',
    providers: [
        { provide: NG_VALIDATORS, useExisting: forwardRef(() => EqualValidator), multi: true }
    ]
})
export class EqualValidator implements Validator {

    /**
     * Constructor of class
     * @param validateEqual     Attribute validateEqual
     */
    constructor(@Attribute('validateEqual') public validateEqual: string) {}

    /**
     * Validate method
     * @param c     Abstract control
     */
    validate(c: AbstractControl): { [key: string]: any } {
        // self value (e.g. retype password)
        let v = c.value;
        // control value (e.g. password)
        let e = c.root.get(this.validateEqual);
        // value not equal
        if (e && v !== e.value) return {
            validateEqual: false
        }
        return null;
    }
}