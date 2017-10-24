// Generated using typescript-generator version 1.29.355 on 2017-10-04 13:28:50.

export interface PolicyChangeData {
  changes:Change[];
  config:Config;
}

export interface Change {
  type:string;
  id:string;
  values:Value[];
}

export interface Value {
  text:string;  // currently not used.
  code:string;
}

export interface Config {
  policyNum:string;
  valueLabels:string[];
  idLabels:any
}
