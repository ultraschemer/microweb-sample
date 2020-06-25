"""Creating document and image relations.

Revision ID: f020117fa010
Revises: 58a0c70dd98a
Create Date: 2020-06-25 10:12:08.692395

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = 'f020117fa010'
down_revision = '58a0c70dd98a'
branch_labels = None
depends_on = None


def upgrade():
    # Create the table 'image' only with data fields. The boilerplate fields (like id, created_at, etc)
    # will be created later
    op.create_table('image')

    # The 'image' relation store read-only registers. These registers are of type Createable. So, set the table as
    # a 'createable' entity - and this function will generate all boilerplate fields to fulfill the needs of a
    # 'createable' entity:
    op.set_createable('image')

    op.create_table('user__image')
    op.set_createable('user__image')

    op.create_table('document')
    op.set_timeable('document')

    op.create_table('user__document')
    op.set_createable('user__document')

def downgrade():
    op.drop_table('user__document')
    op.drop_table('document')
    op.drop_table('user__image')
    op.drop_table('image')
