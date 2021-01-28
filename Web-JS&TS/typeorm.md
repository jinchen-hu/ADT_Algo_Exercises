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

## Migration

A migration is just a single file with sql queries to update a dababase schema and appliy new changes to an existing database

```json
{
  "type": "mysql",
  "host": "localhost",
  "port": 3306,
  "username": "root",
  "password": "root",
  "database": "test",
  "entity": ["entity/*.js"],
  "migrationTableName": "custom_migration_table",
  "migrations": ["migration/*.js"],
  "cli":{
    "migrationsDir": "migration"
  }
}
```

* `"migrationsTableName": "migrations"`: specify this option only if you need migration table name to be different from "migration"
* `"migration": ["migration/*.js"]"`: indicates that typeorm must load migrations from the given directory
* `"cli": {"migrationsDir": "migration"}`: indicates that the CLI must create new migrations in the "migration" directory

`typeorm migration:create -n nameOfMigration` is the CLI to create a new migration file

```typescript
import {MigrationInterface, QueryRunner} from "typeorm";

export class PostRefactoringTIMESTAMP implements MigrationInterface {

    async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`ALTER TABLE "post" RENAME COLUMN "title" TO "name"`);
    }

    async down(queryRunner: QueryRunner): Promise<void> {
        // reverts things made in "up" method
        await queryRunner.query(`ALTER TABLE "post" RENAME COLUMN "name" TO "title"`); 
    }
}
```

`up` has to contain the code that's needed to perform migration

`down` has to revert whatever `up` changed, which means revert the last migration

`typeorm migration:run`: execute all pending migrations and run them in sequence oredered by their timestamps

`typeorm migration:revert`: execute `down`

