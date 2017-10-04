// Generated using typescript-generator version 1.29.355 on 2017-10-04 13:28:50.

export interface Addr {
  addr1: string;
  addr2: string;
  city: string;
  postalCode: string;
  stateProv: string;
  country: string;
}

export interface AutoPolicy {
  policyNumber: string;
  policyEffectiveDate: string;
  insureds: Insured[];
  drivers: Driver[];
  vehicles: Vehicle[];
  locations: Location[];
}

export interface CommercialName {
  commercialName: string;
}

export interface Coverage {
  coverageCd: string;
  limit: number;
  deductible: number;
}

export interface Driver {
  nameInfo: NameInfo;
  gender: string;
  birthday: string;
  maritalStatus: string;
  licenses: License[];
}

export interface Insured {
  nameInfo: NameInfo;
  addr: Addr;
  phoneInfos: PhoneInfo[];
}

export interface License {
  licensedDate: string;
  licenseClass: string;
  licenseNumber: string;
  stateProv: string;
}

export interface Location {
  addr: Addr;
}

export interface NameInfo {
  personName: PersonName;
  commercialName: CommercialName;
}

export interface PersonName {
  surname: string;
  givenName: string;
}

export interface PhoneInfo {
  phoneTypeCd: string;
  communicationUseCd: string;
  phoneNumber: string;
}

export interface QAddr extends EntityPathBase<Addr> {
  addr1: StringPath;
  addr2: StringPath;
  city: StringPath;
  country: StringPath;
  postalCode: StringPath;
  stateProv: StringPath;
}

export interface QAutoPolicy extends EntityPathBase<AutoPolicy> {
  drivers: ListPath<Driver, QDriver>;
  insureds: ListPath<Insured, QInsured>;
  locations: ListPath<Location, QLocation>;
  policyEffectiveDate: StringPath;
  policyNumber: StringPath;
  vehicles: ListPath<Vehicle, QVehicle>;
}

export interface QCommercialName extends EntityPathBase<CommercialName> {
  commercialName: StringPath;
}

export interface QCoverage extends EntityPathBase<Coverage> {
  coverageCd: StringPath;
  deductible: NumberPath<number>;
  limit: NumberPath<number>;
}

export interface QDriver extends EntityPathBase<Driver> {
  birthday: StringPath;
  gender: StringPath;
  licenses: ListPath<License, QLicense>;
  maritalStatus: StringPath;
  nameInfo: QNameInfo;
}

export interface QInsured extends EntityPathBase<Insured> {
  addr: QAddr;
  nameInfo: QNameInfo;
  phoneInfos: ListPath<PhoneInfo, QPhoneInfo>;
}

export interface QLicense extends EntityPathBase<License> {
  licenseClass: StringPath;
  licensedDate: StringPath;
  licenseNumber: StringPath;
  stateProv: StringPath;
}

export interface QLocation extends EntityPathBase<Location> {
  addr: QAddr;
}

export interface QNameInfo extends EntityPathBase<NameInfo> {
  commercialName: QCommercialName;
  personName: QPersonName;
}

export interface QPersonName extends EntityPathBase<PersonName> {
  givenName: StringPath;
  surname: StringPath;
}

export interface QPhoneInfo extends EntityPathBase<PhoneInfo> {
  communicationUseCd: StringPath;
  phoneNumber: StringPath;
  phoneTypeCd: StringPath;
}

export interface QQuestionAnswer extends EntityPathBase<QuestionAnswer> {
  answer: StringPath;
  question: StringPath;
}

export interface QVehicle extends EntityPathBase<Vehicle> {
  annualDistance: NumberPath<number>;
  bodyType: StringPath;
  costNewAmt: StringPath;
  coverages: ListPath<Coverage, QCoverage>;
  engineType: StringPath;
  manufacturer: StringPath;
  model: StringPath;
  modelYear: StringPath;
  purchaseDate: StringPath;
  questionAnswers: ListPath<QuestionAnswer, QQuestionAnswer>;
  rateClassCd: StringPath;
  vehUseCd: StringPath;
  vin: StringPath;
}

export interface QuestionAnswer {
  question: string;
  answer: string;
}

export interface Vehicle {
  manufacturer: string;
  model: string;
  modelYear: string;
  bodyType: string;
  costNewAmt: string;
  annualDistance: number;
  purchaseDate: string;
  vin: string;
  vehUseCd: string;
  engineType: string;
  rateClassCd: string;
  coverages: Coverage[];
  questionAnswers: QuestionAnswer[];
}

export interface StringPath extends StringExpression, Path<string> {
}

export interface Path<T> extends Expression<T> {
  root: Path<any>;
  metadata: PathMetadata;
  annotatedElement: AnnotatedElement;
}

export interface PathMetadata extends Serializable {
  element: any;
  parent: Path<any>;
  rootPath: Path<any>;
  pathType: PathType;
  name: string;
  root: boolean;
}

export interface AnnotatedElement {
  annotations: Annotation[];
  declaredAnnotations: Annotation[];
}

export interface Class<T> extends Serializable, GenericDeclaration, Type, AnnotatedElement {
}

export interface ListPath<E, Q> extends CollectionPathBase<E[], E, Q>, ListExpression<E, Q> {
}

export interface NumberPath<T> extends NumberExpression<T>, Path<T> {
}

export interface StringExpression extends LiteralExpression<string> {
}

export interface Serializable {
}

export interface Annotation {
}

export interface GenericDeclaration extends AnnotatedElement {
  typeParameters: TypeVariable<any>[];
}

export interface Type {
  typeName: string;
}

export interface EntityPathBase<T> extends BeanPath<T>, EntityPath<T> {
}

export interface Expression<T> extends Serializable {
  type: Class<T>;
}

export interface TypeVariable<D> extends Type, AnnotatedElement {
  name: string;
  genericDeclaration: D;
  annotatedBounds: AnnotatedType[];
  bounds: Type[];
}

export interface CollectionPathBase<C, E, Q> extends CollectionExpressionBase<C, E>, Path<C> {
}

export interface ListExpression<E, Q> extends CollectionExpression<E[], E> {
}

export interface NumberExpression<T> extends ComparableExpressionBase<T> {
}

export interface LiteralExpression<T> extends ComparableExpression<T> {
}

export interface AnnotatedType extends AnnotatedElement {
  type: Type;
}

export interface BeanPath<T> extends SimpleExpression<T>, Path<T> {
}

export interface EntityPath<T> extends Path<T> {
}

export interface CollectionExpressionBase<T, E> extends DslExpression<T>, CollectionExpression<T, E> {
  elementType: Class<E>;
}

export interface CollectionExpression<T, E> extends ParameterizedExpression<T> {
}

export interface ComparableExpressionBase<T> extends SimpleExpression<T> {
}

export interface ComparableExpression<T> extends ComparableExpressionBase<T> {
}

export interface SimpleExpression<T> extends DslExpression<T> {
}

export interface DslExpression<T> extends Expression<T> {
}

export interface ParameterizedExpression<T> extends Expression<T> {
}

export type PathType =
  "ARRAYVALUE"
  | "ARRAYVALUE_CONSTANT"
  | "COLLECTION_ANY"
  | "DELEGATE"
  | "LISTVALUE"
  | "LISTVALUE_CONSTANT"
  | "MAPVALUE"
  | "MAPVALUE_CONSTANT"
  | "PROPERTY"
  | "VARIABLE";
