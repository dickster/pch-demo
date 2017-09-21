export class ComponentConfig<T>{
    value: T;
    key: string;
    label: string;
    required: boolean;
    order: number;
    type: string;
    validators : string[];
    css: string;
    placeholder:string;
    showWhen:{parent:string; value:string}[];
    asyncValidators : string[];

    constructor(options: {
                            value?: T,
                            key?: string,
                            label?: string,
                            placeholder?:string,
                            required?: boolean,
                            order?: number,
                            css?: string,
                            type?: string,
                            showWhen?:{parent:string, value:string}[],
                            validators?: string[],
                            asyncValidators?: string[]
                        } = {}) {
        this.asyncValidators = options.asyncValidators;
        this.validators = options.validators;
        this.value = options.value;
        this.key = options.key || '';
        this.label = options.label || '';
        this.required = !!options.required;
        this.order = options.order === undefined ? 1 : options.order;
        this.type = options.type || '';
        this.css = options.css || '';
        this.showWhen = options.showWhen || [];
        this.placeholder = options.placeholder || '';
    }

}
