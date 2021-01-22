# TypeORM

## Object Relational Mapping (ORM)

Object-relational mapping is a technique that lets you query and manipulate data from a database, using an object-oriented paradigm

## Integration

```typescript
@Module({
	imports: [TypeOrmModule.forRoot({
    type:
    host:
    ...
  })]
})
```

Or, create an `ormconfig.json` file in the project root directory, and call `forRoot()` function directly

```typescript
@Module({
	imports: [TypeOrmModule.forRoot()]
})

export class AppModule{
  constructor(private connection: Connection)
}
```

### Auto-load Entities

Set `autoLoadEntities:true` in `forRoot()` function will automatically load every entity registered through `forFeature()`

## Repository Pattern

```typescript
@Entity()
export class CatEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column({ default: true })
  isActive: boolean;
}
```

`forFeature()` method is to define which repositories are registered in the current scope.

```typescript
@Module({
  imports: [TypeOrmModule.forFeature([CatEntity])]
})
```

Use `InjectRepository()` decorator to inject repositories into services

```typescript
@Injectable()
export class CatsService {
  constructor(
  	@InjectRepository: Repository<CatEntity>,
  ){}
}
```

## Relations

`@OneToOne, @OneToMany, @ManyToOne, @ManyToOne`

### Separating Entity Definition

Define entities and their columns inside entity schemas

```typescript
export const UserSchema = new EntitySchema<User>({
  name: 'User',
  target: User,
  columns: {
    id: {
      type: Number,
      primary: true,
      generated: true,
    },
    firstName: {
      type: String,
    },
    lastName: {
      type: String,
    },
    isActive: {
      type: Boolean,
      default: true,
    },
  },
  relations: {
    photos: {
      type: 'one-to-many',
      target: 'Photo', // the name of the PhotoSchema
    },
  },
});
```

