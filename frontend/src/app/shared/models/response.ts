export class Response<T> {
  content: T[] = [];
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
  last: number;
}
