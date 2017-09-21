import { Injectable }       from '@angular/core';
import { DropDownConfig } from './dropdown.config';
import { ComponentConfig }     from './component.config';
import { TextConfig }  from './text.config';
import { QuestionPanelConfig } from './question-panel.config';
import { CheckBoxConfig } from "./checkbox.config";
import {TextAreaConfig} from "./textarea.config";
import {YesNoConfig} from "./yesno.config";
import {AutocompleteConfig} from "./autocomplete.config";

@Injectable()
export class QuestionService {
    // Todo: get from MongoDB
    // Todo: make asynchronous

    getQuestions() {
        let questions: ComponentConfig<any>[] = [

            new AutocompleteConfig( {
                key: 'company',
                label: 'Previous Insurer',
                css:'col-md-3',
                placeholder:'enter insurer',
                choices: [
                    {key: '1',  value: 'Wawanesa'},
                    {key: '2',  value: 'Zurich'},
                    {key: '3',   value: 'State Farm'},
                    {key: '5', value: 'Pembridge'},
                    {key: '6', value: 'Grenville'},
                    {key: '7', value: 'CAA'},
                    {key: '8', value: 'Great White Insurance'},
                    {key: '9', value: 'Gecko'}
                ],
                order: 7
            }),
            new DropDownConfig({
                key: 'vehicleType',
                label: 'Vehicle Type',
                css:'col-md-3',
                choices: [
                    {key: '1',  value: 'GENERAL MOTORS'},
                    {key: '2',  value: 'TOYOTA'},
                    {key: '3',   value: 'MERCEDES BENZ'},
                    {key: '4',   value: 'FIAT CHRYSLER'},
                    {key: '5', value: 'FORD'}
                ],
                order: 3
            }),
            new CheckBoxConfig({
                key: 'underAge',
                label: 'Are you under 18?',
                css:'col-md-3',
            }),
            new YesNoConfig({
                key: 'accident',
                label: 'Have you had an accident?',
                css:'col-md-8',
                showWhen:[{parent:'underAge', value:true}]
            }),
            new TextAreaConfig({
                key: 'accidentDesc',
                label: 'Description',
                placeholder: 'Please describe the GMC accident',
                css:'col-md-12',
                rows:1,
                showWhen:[{parent:'accident', value:'yes'},
                            {parent:'vehicleType', value:'1'}]
            }),
            new QuestionPanelConfig({
                children: [
                    new DropDownConfig({
                        css:'col-md-5',
                        key: 'country',
                        label: 'Country',
                        choices: [
                            {key: '1',  value: 'Canada'},
                            {key: '2',  value: 'USA'},
                            {key: '3',   value: 'Mexico'},
                        ],
                    }),
                ],
                css:'col-md-12',
                order:4
            }),
            new TextConfig({
                key: 'firstName',
                css:'col-md-3',
                label: 'First name',
                value: '',
                required: true,
                order: 1
            }),
            new TextConfig({
                key: 'emailAddress',
                css:'col-md-2',
                label: 'Email',
                inputType: 'email',
                order: 2
            })
        ];
        // TODO : allow for null order. (or ensure order is a number)?
        return questions.sort((a, b) => a.order - b.order);
    }

    getMoreQuestions() {
        let questions: ComponentConfig<any>[] = [

            new YesNoConfig({
                key: 'workDrive',
                label: 'Do you drive to work',
                css:'col-md-8',
                order :1
            }),
            new TextConfig({
                key: 'workDistance',
                css:'col-md-offset-2 col-md-2',
                label: 'Distance',
                required:true,
                inputType: 'number',
                showWhen:[{parent:'workDrive', value:'yes'}],
                order: 2
            }),
            new YesNoConfig({
                key: 'haveWork',
                label: 'Do you work?',
                css:'col-md-6 col-md-offset-2',
                showWhen:[{parent:'workDrive', value:'no'}],
                order :3
            }),

            new YesNoConfig({
                key: 'mvr',
                label: 'Do you have MVR?',
                css:'col-md-8',
                order: 4
            }),
            new DropDownConfig({
                key: 'mvrStatus',
                label: 'MVR Status',
                css:'col-md-3',
                choices: [
                    {key: '1',  value: 'Ordered'},
                    {key: '2',  value: 'Not Ordered'},
                    {key: '3',  value: 'I Dunno'},
                ],
                order: 4
            }),

            new CheckBoxConfig({
                key: 'convertible',
                label: 'The vehicle is a convertible',
                css:'col-md-3',
                order:5
            }),
            new YesNoConfig({
                key: 'original',
                label: 'Are you original owner?',
                css:'col-md-8',
                order:6,
                showWhen:[{parent:'convertible', value:true}]
            }),
            new AutocompleteConfig( {
                key: 'color',
                label: 'What color is your vehicle',
                css:'col-md-3',
                placeholder:'enter a color',
                choices: [
                    {key: '1',  value: 'red'},
                    {key: '2',  value: 'green'},
                    {key: '3',   value: 'blue'},
                    {key: '5', value: 'beige'},
                    {key: '6', value: 'sort of a pinkish brown'},
                    {key: '7', value: 'aqua marine'},
                    {key: '8', value: 'cobalt blue'},
                    {key: '9', value: 'turkish green'}
                ],
                order: 7
            }),
        ];
        // TODO : allow for null order. (or ensure order is a number)?
        return questions.sort((a, b) => a.order - b.order);
    }
}
