using Microsoft.EntityFrameworkCore;

namespace StepDown.Models;
public class UserContext : DbContext {
    public UserContext(DbContextOptions<SongContext> options) : base(options) {
        this.Database.EnsureCreated();
    }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
        optionsBuilder.UseMySQL("server=localhost;database=song_db;user=root;password=12345678");
    }


    protected override void OnModelCreating(ModelBuilder modelBuilder) {
        base.OnModelCreating(modelBuilder);

        modelBuilder.Entity<User>(entity => {
            entity.HasKey(e => e.id);
            entity.Property(e => e.userName);
            entity.Property(e => e.password);
            entity.HasMany(e => e.songs).WithOne(e => e.uploader)
            .HasForeignKey(e => e.uploaderId).HasPrincipalKey(e => e.id);
        });
    }

    public DbSet<User> users {get; set;} = null!;
}